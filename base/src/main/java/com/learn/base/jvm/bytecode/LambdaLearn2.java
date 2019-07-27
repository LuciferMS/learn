package base.bytecode;

/**
 * @program: learn
 * @description: LambdaLearn2
 * @author: Elliot
 * @create: 2019-07-11 20:20
 **/
public class LambdaLearn2 {
    /**
     * 这里是使用lambda表达式的形式
     * 编译器会为每一个lambda表达式生成一个方法
     * 方法名是lambda$0,1,2,3，但方法引用的表达式不会生成方法。
     * 在lambda地方会产生一个invokeDynamic指令，这个指令会调用
     * bootstrap（引导）方法，bootstrap方法会指向自动生成的lambda$0
     * 方法或者方法引用的方法。
     * bootstrap方法使用上是调用了LambdaMetafactory.metafactory静态方法
     * 该方法返回了CallSite(调用站点)，里面包含了MethodHandle（方法句柄）
     * 也就是最终调用的方法。
     * 引导方法只会调用一次。
     *
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("run");
        };
        new Thread(runnable);
        System.out.println(runnable.getClass().getName());
    }
}
