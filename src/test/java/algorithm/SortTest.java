package algorithm;

import org.junit.Test;

public class SortTest {

    @Test
    public void testMaopao(){
        int[] data = {1, 4, 5,3 ,2};
        Sort.maopaoSort(data);
        for (int i:
             data) {
            System.out.println(i);
        }
    }

    @Test
    public void testSelectSort(){
        int[] data = {1, 4, 5,3 ,2};
        Sort.selectSort(data);
        for (int i:
                data) {
            System.out.println(i);
        }
    }

    @Test
    public void testInertSort(){
        int[] data = {1, 4, 5,3 ,2};
        Sort.insertSort(data);
        for (int i : data) {
            System.out.println(i);
        }
    }

    @Test
    public void testQuickSort(){
        int[] data = {1, 4, 5,3 ,2};
        Sort.quickSort(data);
        for (int i : data) {
            System.out.println(i);
        }
    }
}
