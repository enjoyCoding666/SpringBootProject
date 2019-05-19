package com.example.demo.exception;

import lombok.*;

/**
 * @Auther: Administrator
 * @Date: 2019\5\15 0015 22:11
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {

    private String code;
    private String msg;
    private Object data;

    public ResultInfo(ErrorType errorType){
        this.code=errorType.getCode();
        this.msg=errorType.getMsg();
    }

    public ResultInfo(ErrorType errorType,Object data){
        this.code=errorType.getCode();
        this.msg=errorType.getMsg();
        this.data=data;
    }

    public ResultInfo(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
