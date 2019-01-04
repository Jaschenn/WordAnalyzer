package cc.rukia.WordAnalyzer.util;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
//保证程序中只有一个jedis对象
public class RedisUtil {
    private  static Jedis jedis ;
    public static Jedis getJedis(){
        if (jedis==null){
            jedis = new Jedis();
            return jedis;
        }else {
            return jedis;
        }
    }
}
