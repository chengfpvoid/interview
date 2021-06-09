package org.itstack.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CLHLock2 implements Lock {

    private final ThreadLocal<CLHLock2.Node> prev;

    private final ThreadLocal<CLHLock2.Node> node;

    private  final AtomicReference<CLHLock2.Node> tail = new AtomicReference<>(new CLHLock2.Node());

    private static class Node {
        private volatile boolean locked;
    }

    public CLHLock2() {
        prev = ThreadLocal.withInitial(null);
        node = ThreadLocal.withInitial(Node::new);
    }

    @Override
    public void lock() {
        final Node node = this.node.get();
        node.locked = true;
        Node predNode = this.tail.getAndSet(node);
        this.prev.set(predNode);
        while (predNode.locked);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
