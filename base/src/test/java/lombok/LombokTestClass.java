package lombok;

public class LombokTestClass implements ILombokTest {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    public void subMed() {
        System.out.println("我就是我。。");
    }
}
