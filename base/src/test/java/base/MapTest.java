package base;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: learn
 * @description: MapTest
 * @author: Elliot
 * @create: 2019-07-22 14:46
 **/
public class MapTest {

    @Test
    public void mapForEachTest(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Aa", "Aa");
        map.put("BB", "BB");
        map.put("AaBB", "AaBB");
        for (Map.Entry entry : map.entrySet()){

        }
    }

    @Test
    public void mapForEachTest2(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Aa", "Aa");
        map.put("BB", "BB");
        map.put("AaBB", "AaBB");

    }
}
