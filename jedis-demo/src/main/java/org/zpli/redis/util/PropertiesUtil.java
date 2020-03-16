package org.zpli.redis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/13 17:51
 */
public class PropertiesUtil {

    private static Properties properties = new Properties();

    public static Properties loadProperties(String fileName) {
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            if (null == inputStream) {
                System.out.println(String.format("---------- 加载配置文件 [%s] 失败 ----------",fileName));
            } else {
                System.out.println(String.format("---------- 加载配置文件 [%s] 成功 ----------",fileName));
                properties.load(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String keyStr) {
        return properties.getProperty(keyStr);
    }
}
