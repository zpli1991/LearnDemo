package org.zpli.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/4/23 14:14
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.zpli.spring")
public class SpringConfig {
}
