package com.example.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Auther: Administrator
 * @Date: 2019\7\10 0010 23:55
 * @Description:
 */
@Component
@Slf4j
public class AsyncService {
    /**
     * Async注解表示异步，后面的参数对应于线程池配置类ExecutorConfig中的方法名asyncServiceExecutor()，
     * 如果不写后面的参数，直接使用@Async注解，则是使用默认的线程池
     * Future<String>为异步返回的结果。可以通过get()方法获取结果。
     *
     * @return
     */
    @Async("asyncServiceExecutor")
    public Future<String> getDataResult( ){
        log.info("开始异步处理");
        String result="asyncResultTest";
        return new AsyncResult<String>(result);
    }


}
