package com.learn.base.java.concurrent.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learn
 * @description: 自制阻塞队列 循环队列模式
 * @author: Elliot
 * @create: 2019-08-17 01:02
 **/
public class MyArrayBlockingQueue<E> implements BlockingQueue<E> {

    private final Lock lock = new ReentrantLock();

    private final Condition empty = lock.newCondition();

    private final Condition full = lock.newCondition();

    private final int len;

    /**
     * 数据
     */
    private final Object[] data;
    /**
     * size
     */
    private int size;
    /**
     * 数据区域尾结点
     */
    private int rear;
    /**
     * 数据区域头结点
     */
    private int front;

    public MyArrayBlockingQueue(int cap) {
        data = new Object[cap];
        len = cap;
    }

    /******************** implements of BlockingQueue *********************/
    @Override
    public boolean add(E e) {
        if (isFull()){
            try {
                full.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        data[++rear % len] = e;
        size++;
        return false;
    }

    private boolean isFull() {
        return len == size;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public void put(E e) throws InterruptedException {

    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        return null;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    /**************** implements of Queue ****************/
    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    /************* implements of Collections ************/
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
