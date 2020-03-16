package org.zpli.jedis;

import org.junit.Test;
import org.zpli.redis.util.PropertiesUtil;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/13 18:13
 */
public class JedisTest {

    @Test
    public void test1(){
        PropertiesUtil.loadProperties("redis.properties");
        System.out.println(PropertiesUtil.getProperty("redis.port"));
    }
}
