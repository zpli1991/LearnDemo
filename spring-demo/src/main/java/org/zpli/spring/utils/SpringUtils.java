package org.zpli.spring.utils;

import org.springframework.context.ApplicationContext;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/23 13:59
 */
public class SpringUtils {

    private static ApplicationContext ctx;

    public static void setCtx(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return ctx.getBean(beanClass);
    }
}
