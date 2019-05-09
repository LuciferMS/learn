package base.thread.callableLearn;

import java.util.concurrent.Callable;

/**
 * @author Elliot
 * 创建线程第三种方式实现Callable接口
 *
 */
public class CallDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        String th_name = Thread.currentThread().getName();
        System.out.println(th_name + "遭遇大规模敌军偷袭...");
        System.out.println(th_name + "迅速变换阵型...");
        System.out.println(th_name + "急速攻杀敌军...");
        return "敌军损失惨重,我军大获全胜";
    }
}
