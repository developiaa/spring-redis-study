package pro.developia.basic;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

public class HashTest {
    @Test
    void hashTest() {
        try (var jedisPool = new JedisPool("127.0.0.1", 6379, null, "password")) {
            try (Jedis jedis = jedisPool.getResource()) {
                // hset
                jedis.hset("users:2:info", "name", "greg2");

                var userInfo = new HashMap<String, String>();
                userInfo.put("email", "greg3@fastcampus.co.kr");
                userInfo.put("phone", "010-XXXX-YYYY");

                jedis.hset("users:2:info", userInfo);
                // 같은 키면 덮어 씌움
                jedis.hset("users:2:info", "phone", "010-YYYY-XXXX");

                // hdel
                jedis.hdel("users:2:info", "phone");

                // get, getall
                System.out.println(jedis.hget("users:2:info", "email"));
                Map<String, String> user2Info = jedis.hgetAll("users:2:info");
                user2Info.forEach((k, v) -> System.out.printf("%s %s%n", k, v));

                // hincr
                jedis.hincrBy("users:2:info", "visits", 30);
            }
        }
    }
}
