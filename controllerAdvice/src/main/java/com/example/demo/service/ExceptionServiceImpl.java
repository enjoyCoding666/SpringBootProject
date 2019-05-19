package com.example.demo.service;


import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorType;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Administrator
 * @Date: 2019\5\14 0014 22:20
 * @Description:   统一异常处理。直接在服务层抛异常。
 */
@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Override
    @Transactional
    public User getUserById(Integer id)  {
        //实际项目中这里一般都会有Dao层查询user，
        // 比如 User user =userDao.getUser(id);
        // 此Demo为了方便，忽略不写。直接假设user查询结果为null
        User user=null;
        if(user==null) {
            throw new BusinessException(ErrorType.ID_IS_NULL);
        }
        return  user;
    }

    @Override
    @Transactional
    public String getUserName(User user)  {
        String name=user.getUserName();
        if(name==null) {
            throw  new BusinessException(ErrorType.NAME_IS_NULL);
        }
        return name;
    }

}
