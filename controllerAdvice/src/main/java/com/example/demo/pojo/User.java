package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Administrator
 * @Date: 2019\5\15 0015 22:15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "@NotNull错误信息：id不能为空")
    private Integer id;
    @NotNull(message = "@NotNull错误信息：name不能为空")
    //这里的属性名为"name"时，校验没有生效，如果是其他命名，比如userName就可以校验，很诡异的bug。
    private String userName;
    @Min(value = 18,message = "@NotNull错误信息：age不能小于18岁")
    private Integer age;

    private String phoneNumber;
}
