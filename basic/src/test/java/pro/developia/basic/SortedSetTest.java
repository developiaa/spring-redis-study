package pro.developia.basic;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.resps.Tuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortedSetTest {
    @Test
    void hashTest() {
        try (var jedisPool = new JedisPool("127.0.0.1", 6379, null, "password")) {
            try (Jedis jedis = jedisPool.getResource()) {
                // sorted set - Leader boadrd, Rate limit
                var scores = new HashMap<String, Double>();
                scores.put("users1", 100.0);
                scores.put("users2", 30.0);
                scores.put("users3", 50.0);
                scores.put("users4", 80.0);
                scores.put("users5", 15.0);

                jedis.zadd("game2:scores", scores);

                List<String> zrange = jedis.zrange("game2:scores", 0, Long.MAX_VALUE);
                zrange.forEach(System.out::println);

                System.out.println(jedis.zcard("game2:scores"));

                jedis.zincrby("game2:scores", 100.0, "users5");

                List<Tuple> tuples = jedis.zrangeWithScores("game2:scores", 0, Long.MAX_VALUE);
                tuples.forEach(i -> System.out.printf("%s %f%n", i.getElement(), i.getScore()));
            }
        }
    }
}
