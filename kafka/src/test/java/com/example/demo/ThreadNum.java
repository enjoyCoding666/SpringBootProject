package com.example.demo;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadNum {


    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ThreadNum.printfNumList(list);
    }


    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            5, 20,
            2000,
            TimeUnit.MICROSECONDS,
            new ArrayBlockingQueue<>(100),
            r -> new Thread(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * A线程，1，3，5，7，9
     * B线程，2，4，6，8，10
     * 打印结果。
     */
    public static void printfNumList(List<Integer> numList) throws InterruptedException {
        if (CollectionUtils.isEmpty(numList)) {
            return;
        }
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (Integer num : numList) {
            if (num % 2 == 1) {
                firstList.add(num);
            } else {
                secondList.add(num);
            }
        }
        EXECUTOR.execute(() -> print(firstList));
        EXECUTOR.execute(() -> print(secondList));

    }

    private static void print(List<Integer> list) {
        try {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }


}
