package base;

import java.util.List;

/**
 * @author Elliot
 * 异常相关学习
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            Integer i = new Integer("1a");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                List<Integer> list = null;
                list.add(1);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
