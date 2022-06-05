package com.theadpool;

import com.theadpool.factory.NamedTheadFactory;
import com.theadpool.task.EchoTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloWorld {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new NamedTheadFactory());
        String echoMessage = "你还好吗? ";

        //新启一个单线程执行
        new Thread(() -> System.out.println(Thread.currentThread().getName() + ":" + echoMessage)).start();

        //线程池执行
        executorService.submit(new EchoTask(echoMessage)).get();

        //主线程
        System.out.println(Thread.currentThread().getName() + ":" + echoMessage);

    }
}
