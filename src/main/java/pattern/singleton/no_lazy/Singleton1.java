package pattern.singleton.no_lazy;

/**
 * @author Elliot
 * @date 2019/6/2
 */
public class Singleton1 {

    //public static final Singleton1 INSTANCE = new Singleton1();

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
