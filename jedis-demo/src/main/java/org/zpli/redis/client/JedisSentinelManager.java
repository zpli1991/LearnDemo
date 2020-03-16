package org.zpli.redis.client;

import org.apache.commons.lang3.StringUtils;
import org.zpli.logger.LoggerManager;
import org.zpli.redis.exception.DataException;
import org.zpli.redis.util.PropertiesUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/13 18:29
 */
public class JedisSentinelManager {


    private static JedisSentinelPool jedisSentinelPool = null;

    private static Properties properties;

    static {
        if (null == properties) {
            properties = PropertiesUtil.loadProperties("redis.properties");
        }
    }

    private static JedisPoolConfig getJedisPoolConfig() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        jedisPoolConfig.setMaxTotal(Integer.valueOf(properties.getProperty("redis.max.total")));
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        jedisPoolConfig.setMaxIdle(Integer.valueOf(properties.getProperty("redis.max.idle")));
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        jedisPoolConfig.setMinEvictableIdleTimeMillis(Integer.valueOf(-1));
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(false));
        jedisPoolConfig.setTestOnReturn(Boolean.valueOf(true));
        return jedisPoolConfig;
    }

    public static void initJedisSentinelPool() throws DataException {
        // master名称和配置文件中配置的要一样
        String masterName = properties.getProperty("redis.sentinel.master");
        if (StringUtils.isBlank(masterName)) {
            LoggerManager.getDailyLog().error("获取SentinelRedis缓存name不能为空");
            throw new DataException("获取SentinelRedis缓存name不能为空");
        }
        initJedisSentinelPool8Name(masterName);
    }

    private static void initJedisSentinelPool8Name(String masterName) throws DataException {
        String nodes = properties.getProperty("redis.sentinel.nodes");
        if (StringUtils.isBlank(nodes)) {
            LoggerManager.getDailyLog().error("没有配置SentinelRedis节点，请检查。。。");
            throw new DataException("没有配置SentinelRedis节点，请检查。。。");
        }
        String[] sentinels = nodes.split(",");
        Set<String> sentinelNodes = Arrays.stream(sentinels).collect(Collectors.toSet());
        jedisSentinelPool = new JedisSentinelPool(masterName, sentinelNodes, getJedisPoolConfig());
    }

    public static Jedis getResource() throws DataException {
        Jedis jedis = jedisSentinelPool.getResource();
        if (null != jedis) {
            return jedis;
        } else {
            throw new DataException("获取SentinelRedis连接为空");
        }
    }

    public static void releaseResource(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }
}
