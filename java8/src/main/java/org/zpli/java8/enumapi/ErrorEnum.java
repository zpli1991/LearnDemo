package org.zpli.java8.enumapi;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 枚举中自定义构造方法
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/1 15:17
 */
public enum ErrorEnum {

    NOT_FOUND_ERROR(10030, "未找到对应信息"),
    PARAM_EMPTY_ERROR(10031, "参数为空");

    private int code;
    private String desc;

    ErrorEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc8Code(int code) {
        String result = "";
        ErrorEnum[] values = ErrorEnum.values();
        for (ErrorEnum errorEnum : values) {
            if (code == errorEnum.code) {
                result = errorEnum.desc;
                break;
            }
        }
        return result;
    }
}
