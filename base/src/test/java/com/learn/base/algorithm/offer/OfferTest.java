package algorithm.offer;

import org.junit.Test;

public class OfferTest {

    @Test
    public void matrixTest() {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'a', 'b', 'c', 'b'};
        int rows = 3;
        int cols = 4;
        boolean result = Matrix.hasPath(matrix, rows, cols, str);
        System.out.println(result);
    }

}
