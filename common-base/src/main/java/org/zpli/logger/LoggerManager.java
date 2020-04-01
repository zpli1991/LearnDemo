package org.zpli.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/4 16:57
 */
public class LoggerManager {

    public static Logger getDailyLog() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTraceElement[0].getClassName());
    }

    public static Logger getSystemLog() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTraceElement[1].getClassName());
    }

    public static Logger getErrorLog() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        return LoggerFactory.getLogger(stackTraceElement[2].getClassName());
    }
}
