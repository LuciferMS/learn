/**
 * @program: learn
 * @description: netty学习第一站，nio
 * java.io中，核心的概念是流(stream)一个流要么是输入流，要么是输出流。面向流编程
 * java.nio中有三个核心概念，channel，selector和buffer。面向块（block）或者缓冲区(buffer)编程
 * buffer本身就是一块内存，底层是数组，数据读写都是通过buffer实现的
 * java中的基本数据类型都有其对应的buffer，但是没有booleanBuffer
 *
 * channel是可以从中读取数据和写入数据的对象，类似于java.io的stream
 * 但是channel本身并不携带数据，只是提供对数据的操作，stream本身携带数据
 *
 * channel是双向的，一个流只能是输入流或者输出流，但是channel可以写入数据，也可以读取数据
 * @author: Elliot
 * @create: 2019-07-31 01:32
 **/
package com.learn.netty.nio;