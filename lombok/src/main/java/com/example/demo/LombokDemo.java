package com.example.demo;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019\5\12 0012 22:11
 * @Description:
 */
public class LombokDemo {

    public Company createCompany(){
        Integer agentId=1;
        Integer agentUserId=1;
        String companyName="google";
        String agentUserName="amazon";
        String domain="test";
        String taxNo="11111111111111";
        Integer auth=1;
        Integer useType=1;
        String activationCode="1321-2311-4976";
        String phoneNumber="66666666666666";
        Company company=Company.builder().agentId(agentId).agentUserId(agentUserId).companyName(companyName)
                        .agentUserName(agentUserName).domain(domain).taxNo(taxNo).createTime(new Date())
                        .isAuth(auth).activationCode(activationCode).userType(useType).phoneNumber(phoneNumber)
                         .build();
        return  company;

    }



}
