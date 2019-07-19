package redis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author Elliot
 * java 与 redis 测试
 */
public class RedisTest {

    private Jedis jedis;

    @Before
    public void init() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    /**
     * java与redis的联通测试
     */
    @Test
    public void connectTest() {
        Assert.assertEquals("PONG", jedis.ping());
    }

    @Test
    public void getSetTest() {
        jedis.set("k1", "v1");
        Assert.assertEquals("v1", jedis.get("k1"));
    }

}
