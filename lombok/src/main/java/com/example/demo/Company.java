package com.example.demo;

import lombok.*;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019\5\12 0012 22:06
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Company {
    @NonNull
    private Integer agentId;
    @NonNull
    private Integer agentUserId;
    private String companyName;
    private String agentUserName;
    private String domain;
    private String taxNo;
    private Date createTime;
    private Integer isAuth;
    private String activationCode;
    private String authCode;
    private Integer userType;
    private String phoneNumber;


}
