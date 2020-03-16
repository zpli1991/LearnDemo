package org.zpli.redis.exception;


/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/16 10:45
 */
public class DataException extends Exception {

    private int errorCode;

    public DataException(String msg) {
        super(msg);
    }

    public DataException(int code, String msg) {
        super(msg);
        this.errorCode = code;
    }

    public DataException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = code;
    }

    public DataException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataException(Throwable cause) {
        super(cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return "[" + this.errorCode + "] " + super.getMessage();
    }
}
