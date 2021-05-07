package org.itstack.interview;

import java.util.concurrent.CountDownLatch;

public class AtomicityTest {

    private static volatile int counter = 0;

    // private  static final

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {

                System.out.println("cuurent thread id:" + Thread.currentThread().getName());
                for (int i1 = 0; i1 < 10000; i1++) {

                    add();
                   // addNoSync();
                }
                countDownLatch.countDown();
                System.out.println("count down count:" + countDownLatch.getCount());
            });

            thread.start();
        }
        // 等10个线程运行完毕
        //Thread.sleep(1000);
        countDownLatch.await();
        System.out.println(counter);
    }

    public static void add() {
        synchronized (AtomicityTest.class) {
            counter++;
        }
    }
    public static void addNoSync() {
        counter++;

    }

}

