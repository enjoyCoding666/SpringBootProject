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
    FAIL("0404", "失败");

    public String code;
    public String msg;

    private ErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
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