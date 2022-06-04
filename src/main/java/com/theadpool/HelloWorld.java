package com.theadpool;

import com.theadpool.factory.NamedTheadFactory;
import com.theadpool.task.EchoTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HelloWorld {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new NamedTheadFactory());
        String echoMessage = "你还好吗? ";

        //单个线程执行
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + echoMessage);
        }).start();


        //线程池执行
        Future<String> future = executorService.submit(new EchoTask(echoMessage));
        try {
            System.out.println(Thread.currentThread().getName() + ":" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
