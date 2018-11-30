package com.example.validator.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

/**
 * Created by lenovo on  十一月
 */

/**
 * 使用lombok简化getter、setter、构造方法
 * 使用validator校验数据
 */
@Setter
@Getter
@NoArgsConstructor
public class User {

    @NotBlank(message = "用户名不可为空")
    private String userName;

    @NotBlank(message = "年龄不可为空")
    @Pattern(regexp = "^[0,9]{1,2}$",message = "年龄超过范围")
    private String age;

    @AssertTrue(message = "必须为true")
    private Boolean isVip;

    @Pattern(regexp = "^[0,9]{4}-[0,9]{2}-[0,9]{2}$")
    private String birthday;

}
