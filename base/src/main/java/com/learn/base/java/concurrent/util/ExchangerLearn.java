package com.learn.base.java.concurrent.util;

import java.util.concurrent.Exchanger;

/**
 * @program: learn
 * @description: ExchangerLearn
 * @author: Elliot
 * @create: 2019-07-17 22:02
 * 数据交换器，用于交换两个线程之间的数据.....
 **/
public class ExchangerLearn {

    static class Bike extends Thread {

        private Exchanger<String> exchanger;

        public Bike(Exchanger<String> exchanger, String name) {
            this.setName(name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + exchanger.exchange("Bike"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Car extends Thread {

        private Exchanger<String> exchanger;

        public Car(Exchanger<String> exchanger, String name) {
            this.setName(name);
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + exchanger.exchange("Car"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Bike(exchanger, "Bike").start();
        new Car(exchanger, "Car").start();
        System.out.println("Main end");
    }
}
