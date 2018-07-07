/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coderanch01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Piet
 */
public class ZulfiKhan {

}

class Threads2SyncSolve extends Thread {

    private final String name;
    private static final Lock lock = new ReentrantLock();

    Threads2SyncSolve(String s) {
        name = s;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 100; ++i) {
                System.out.print(name + " " + i + "\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }

    public static void main(String args[]) {
        Threads2SyncSolve obj1 = new Threads2SyncSolve("first");
        Threads2SyncSolve obj2 = new Threads2SyncSolve("Second");
        Threads2SyncSolve obj3 = new Threads2SyncSolve("Third");
        obj1.start();
        obj2.start();
        obj3.start();
    }
}

class Zulfi {
    
    Lock lock = new ReentrantLock();
    
    public static void main(String... args) throws InterruptedException {
        new Zulfi().go();
    }
    
    public void go() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(new Piet("first"));
        es.execute(new Piet("second"));
        es.execute(new Piet("third"));
        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS);
    }
    
    class Piet implements Runnable {
        String name;
        Piet(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 1; i <= 100; i++) System.out.println(name + ": " + i);
            }
            finally {
                lock.unlock();
            }
        }
    }
}
