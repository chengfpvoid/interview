package org.itstack.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VisibilityTest {

    private final static Logger logger = LoggerFactory.getLogger(VisibilityTest.class);

    public static boolean sign = false;

    public static void main(String[] args) {
        Thread Thread01 = new Thread(() -> {
            int i = 0;
            while (!sign) {
                i++;
                add(i);
              //  addNoSync(i); // 去掉同步锁之后就没有可见性了 循环无法退出
            }
        });
        Thread Thread02 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignore) {
            }
            sign = true;
            logger.info("vt.sign = true  while (!sign)");
        });
        Thread01.start();
        Thread02.start();
    }

    public static synchronized int add(int i) {
        return i + 1;
    }
    public static  int addNoSync(int i) {
        return i + 1;
    }

}
