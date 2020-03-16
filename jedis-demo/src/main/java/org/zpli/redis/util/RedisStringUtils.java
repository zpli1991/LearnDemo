package org.zpli.redis.util;

import org.zpli.redis.client.JedisSentinelManager;
import org.zpli.redis.exception.DataException;
import redis.clients.jedis.Jedis;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/13 9:48
 */
public class RedisStringUtils {

    public static void saveData(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisSentinelManager.getResource();
            jedis.set(key, value);
        } catch (DataException e) {
            e.printStackTrace();
        } finally {
            JedisSentinelManager.releaseResource(jedis);
        }

    }


    public static String getData(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = JedisSentinelManager.getResource();
            value = jedis.get(key);
        } catch (DataException e) {
            e.printStackTrace();
        } finally {
            JedisSentinelManager.releaseResource(jedis);
        }
        return value;
    }

    public static boolean exist(String key) {
        Boolean exists = null;
        Jedis jedis = null;
        try {
            jedis = JedisSentinelManager.getResource();
            exists = jedis.exists(key);
        } catch (DataException e) {
            e.printStackTrace();
        } finally {
            JedisSentinelManager.releaseResource(jedis);
        }
        return exists;
    }
}
