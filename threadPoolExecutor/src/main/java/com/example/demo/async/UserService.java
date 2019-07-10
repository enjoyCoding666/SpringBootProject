package com.example.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Auther: Administrator
 * @Date: 2019\7\11 0011 0:08
 * @Description:
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private AsyncService asyncService;

    /**
     * 调用异步服务，获取异步结果。
     * @return
     */
    public String getAsyncResult()  {
        Future<String>  future=asyncService.getDataResult();
        String result=null;
        try{
            result =future.get();
        }catch (InterruptedException | ExecutionException e) {
            log.error("error：{}",e.getMessage());
        }
        log.info("异步处理结果为：{}",result);
        return result;
    }

}
