import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisTest {
    private Jedis jedis;
    @Before
    public void setJedis(){
        jedis = new Jedis("127.0.0.1",6379);
        //jedis.auth("Jasc");
        System.out.println("连接成功");
    }
    @Test
    public void testMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","jaschenn");
        map.put("age","100");
        jedis.hmset("user",map);
        List list = jedis.hmget("user","name");
        System.out.println(list);
        //jedis.del("user");
        System.out.println(jedis.exists("user"));
    }
}
