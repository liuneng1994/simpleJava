package com.hand.ln;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    private static volatile boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                number++;
            }
            System.out.println(number);
        }
    }

    public strictfp static void main(String[] args) throws InterruptedException, IOException {
        // double a =0.0;
        // new ReaderThread().start();
        // Thread.sleep(1);
        // ready = true;
        // System.out.println("wake");
        double a = 3.2;
        double b = 3.0;
        System.out.println("中文");
    }
}
