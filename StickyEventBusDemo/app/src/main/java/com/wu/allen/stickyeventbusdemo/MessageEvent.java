package com.wu.allen.stickyeventbusdemo;

/**
 * Created by allen on 2016/9/7.
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public MessageEvent setMessage(String message) {
        this.message = message;
        return this;
    }
}
