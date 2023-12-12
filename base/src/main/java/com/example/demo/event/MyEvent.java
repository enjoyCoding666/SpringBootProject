package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private String name;

    private String orderId;

    /**
     * 构造方法
     *
     * @param source
     */
    public MyEvent(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
