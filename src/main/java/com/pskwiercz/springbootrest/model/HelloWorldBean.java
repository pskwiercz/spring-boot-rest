package com.pskwiercz.springbootrest.model;

import org.springframework.context.annotation.Bean;

public class HelloWorldBean {

    private String helloMessage;

    public HelloWorldBean(String msg) {
        this.helloMessage = msg;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "helloMessage='" + helloMessage + '\'' +
                '}';
    }
}
