package com.yis.study.kaiyuan.eventbus;

/**
 * Created by liuyi on 2021-03-24.
 */
public class MessageEvent {

    String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
