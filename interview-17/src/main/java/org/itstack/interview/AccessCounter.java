package org.itstack.interview;

import java.util.concurrent.atomic.AtomicInteger;

public class AccessCounter {

    private AtomicInteger count = new AtomicInteger(0);

    public int access() {
        count.incrementAndGet();
        System.out.println(count.get());
        return count.get();
    }
}
