package com.example.demo.exception;


/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 22:06
 * @Description: 自定义异常
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;

    public BusinessException(ErrorType error) {
        super(error.getMsg());
        this.code = error.getCode();
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
