package com.theadpool.factory;

import java.util.concurrent.ThreadFactory;

public class NamedTheadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("echo-thead");
        return thread;
    }
}
