package org.zpli.java8.dateapi;

import org.zpli.logger.LoggerManager;

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/5 14:02
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2020-11-24");
        LoggerManager.getDailyLog().info(localDate.toString());
        System.out.println("加："+localDate.plusDays(9));
        System.out.println("减："+localDate.minus(1, ChronoUnit.MONTHS));
    }
}
