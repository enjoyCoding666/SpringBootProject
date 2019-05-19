package com.example.demo.exception;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 21:57
 * @Description:   错误类型枚举类
 */
public enum ErrorType {
    SUCCESS("0000", "成功"),
    SESSION("0001", "session失效"),
    PERMSION("0002","无权限"),
    TOKEN("0003","token失效"),
    FAIL("0004", "失败"),


    EXCEPTION_FAIL("0005","统一异常处理Exception返回错误结果") ,
    NAME_IS_NULL("0501","ErrorType：用户名为空") ,
    ID_IS_NULL("0502","ErrorType：ID不能为空") ,
    USER_IS_NULL("0503" ,"ErrorType：UER为空") ,

    ;

    private String code;
    private String msg;

    private ErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ErrorType() {
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