package com.example.demo.event;

import com.example.demo.BaseApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * EventPublisherService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/12/2023</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class EventPublisherServiceTest {

    @Resource
    private EventPublisherService eventPublisherService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: doSomething()
     */
    @Test
    public void testDoSomething() throws Exception {
//TODO: Test goes here...
        eventPublisherService.doSomething();
    }


} 
