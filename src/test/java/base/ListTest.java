package base;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class ListTest {

    @Test
    public void randomAccessTest(){
        List<Integer> list = new ArrayList<>();
        Assert.assertEquals(true, list instanceof RandomAccess);
    }

}
