package com.theadpool.task;

import java.util.concurrent.Callable;

public class EchoTask implements Callable<String> {

    private String echoMessage;

    public EchoTask(String echoMessage) {
        this.echoMessage = echoMessage;
    }

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + ":" + echoMessage);
        return echoMessage;
    }

}
