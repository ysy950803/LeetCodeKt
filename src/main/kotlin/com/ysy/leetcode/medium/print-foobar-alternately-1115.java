package com.ysy.leetcode.medium;

import java.util.concurrent.Semaphore;

class FooBar1115 {
    private int n;
    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(0);

    public FooBar1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s1.release();
        }
    }
}

class FooBar1115_2 {
    private int n;
    private final Object lock = new Object();
    private boolean isPrintFoo = true;

    public FooBar1115_2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!isPrintFoo) lock.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isPrintFoo = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (isPrintFoo) lock.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isPrintFoo = true;
                lock.notifyAll();
            }
        }
    }
}
