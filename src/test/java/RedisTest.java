import cc.rukia.WordAnalyzer.util.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisTest {
    private Jedis jedis;

    @Test
    public void testMap(){
        jedis = RedisUtil.getJedis();
        Map map = new HashMap();
        List list1 = new ArrayList();
        list1.add("asas");
        list1.add("bbbb");
        map.put("name","jaschenn");
        map.put("age","100");
        jedis.hmset("user",map);
        List list = jedis.hmget("user","name");
        System.out.println(list);
        map.clear();
        map.put("name","jas");
        map.put("sex","male");
        map.put("list",list1.toString());
        jedis.hmset("user",map);//非法的无法插入
        list = jedis.hmget("user","name","sex","list");//插入相同的数据的时候会更新数据，hashMap中的键也会更新
        System.out.println(list.toString());
        //jedis.del("user");
        System.out.println(jedis.exists("user"));
    }
}
