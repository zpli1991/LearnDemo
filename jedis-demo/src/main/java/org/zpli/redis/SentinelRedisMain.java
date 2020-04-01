package org.zpli.redis;

import org.zpli.redis.client.JedisSentinelManager;
import org.zpli.redis.exception.DataException;
import org.zpli.redis.util.RedisStringUtils;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 11:25
 */
public class SentinelRedisMain {

    public static void main(String[] args) throws DataException {
        JedisSentinelManager.initJedisSentinelPool();
        // RedisStringUtils.saveData(null,"");

        RedisStringUtils.getData(null);

        System.out.println(RedisStringUtils.exist("name"));
        System.out.println(RedisStringUtils.exist("age"));
        System.out.println(RedisStringUtils.getData("name"));
    }
}
