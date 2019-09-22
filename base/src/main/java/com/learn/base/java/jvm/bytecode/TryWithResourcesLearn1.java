package com.learn.base.java.jvm.bytecode;

/**
 * @program: learn
 * @description: TryWithResourcesLearn1
 * @author: Elliot
 * @create: 2019-07-13 20:31
 **/
public class TryWithResourcesLearn1 {
    /**
     * finally抛出的异常会覆盖try中抛出的异常
     * Java 7 中 为 Throwable 类 增 加 的 addSuppressed 方 法。当 一 个异 常 被 抛 出 的 时 候 ,
     * 可 能 有 其 他 异 常 因 为 该 异 常 而 被 抑 制 住 , 从 而 无 法 正 常 抛 出 。 这时 可 以
     * 通 过addSuppressed 方 法 把 这 些 被 抑 制 的 方 法 记 录 下 来 。 被 抑 制 的 异 常 会 出
     * 现在 抛 出 的 异 常 的 堆 栈 信 息 中 , 也 可 以 通 过 getSuppressed 方 法 来 获 取 这 些 异
     * 常 。 这 样做 的 好 处 是 不 会 丢 失 任 何 异 常 , 方 便 开 发 人 员 进 行 调 试 。
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            throw new RuntimeException("in try");
        } finally {
            throw new RuntimeException("in finally");
        }
    }

}
