package org.example;

import java.util.concurrent.Semaphore;

public class T1114 {
    class Foo {
        Semaphore two = new Semaphore(0);
        Semaphore three = new Semaphore(0);

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            two.acquire();
            printSecond.run();
            three.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            three.acquire();
            printThird.run();
        }
    }
}
