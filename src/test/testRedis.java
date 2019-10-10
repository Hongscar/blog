import com.hong.domain.Article;
import com.hong.service.Test_Service;
import com.hong.utils.redis.RedisUtil;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import redis.clients.jedis.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 14:50 2019/8/31
 */
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})
public class testRedis  extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private Test_Service service;

//    @Autowired
//    private RedisUtil util;

    @Test
    @Rollback(value = false)
    public void test() {
        List<Article> articles = service.getAllArticles();
        for (Article article : articles)
            System.out.println(article.getTitle());
    }

    public static void main(String[] args) {



//        RedisAccessor accessor = new RedisAccessor();
//        RedisConnectionFactory factory = accessor.getConnectionFactory();
//        JedisPoolConfig config = new JedisPoolConfig();
//        JedisPool pool = new JedisPool(config, "129.129.232.133", 6379);
//
//        for (int i = 0; i < 8; i++) {
//            Jedis jedis = null;
//            try {
//                jedis = pool.getResource();
//                jedis.auth("123");
//                jedis.ping();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("xxx");
//        Jedis jedis = pool.getResource();       // 执行到这里的时候会停住，因为前面8个连接都已经被get，只能等待释放
//        jedis.auth("123");
//        jedis.ping();
//        System.out.println("qqq");



        //String host = "129.129.232.133";

//        /*  Jedis connect test */
//        try {
//            String host = "129.129.232.133";
//            int port = 6379;
//            Jedis jedis = new Jedis(host, port);
//
//            jedis.auth("123");
//            String key = "redis_test";
//            String value = "Hello-tencentCloud-redis";
//
//            //jedis.select(1);
//            jedis.set(key, value);
//
//            System.out.println("Set key " + key + " Value: " + value);
//
//            String getValue = jedis.get(key);
//            System.out.println("GetKey " + key + " ReturnValue: " + getValue);
//
//            jedis.quit();
//            jedis.close();
//        }   catch (Exception e) {
//            e.printStackTrace();
//        }


        /*  book demo1
        Jedis jedis = new Jedis("129.129.232.133");
        jedis.auth("123");

        String restaurant = "Pizza Hut";
        jedis.set(restaurant, "300 Broadway, New Youk, NY");
        jedis.append(restaurant, " 10011");
        String address = jedis.get("Pizza Hut");
        System.out.printf("Address for %s is %s\n", restaurant, address);

        //List operations
        String listKey = "favorite_restaurants";
        jedis.lpush(listKey, "PF Chang's", "Olive Garden");
        jedis.rpush(listKey, "Outback Steakhouse", "Red Lobster");
        List<String> list = jedis.lrange(listKey, 0, -1);
//        System.out.printf("Favorite restaurants: %s\n" + list);
        System.out.println("--------------");
        for (String str: list)
            System.out.println(str);
            */

//        Jedis jedis = new Jedis(host);
//        jedis.auth("123");

        /*  pipeline example
        Pipeline pipeline = jedis.pipelined();
        pipeline.set("mykey", "myvalue");
        pipeline.sadd("myset", "value1", "value2");
        Response<String> stringValue = pipeline.get("mykey");
        Response<Long> noElementsInSet = pipeline.scard("myset");
        //send commands
        pipeline.sync();
        //Handle responses
        System.out.printf("mykey: %s\n", stringValue.get());
        System.out.printf("Number of Elements in set: %d\n", noElementsInSet.get());
        */

        /* test transaction
        String usr = "user:1000";
        String restCount = "rest_orders:200";
        String restUser = "rest_users:200";
        jedis.auth("123");
        jedis.set(restCount, "400");
        jedis.sadd(restUser, "user:302", "user:401");

        Transaction transaction = jedis.multi();
        Response<Long> countResponse = transaction.incr(restCount);
        transaction.sadd(restUser, usr);
        Response<Set<String>> userSet = transaction.smembers(restUser);
        transaction.exec();

        System.out.printf("Number of orders: %d\n", countResponse.get());
        System.out.printf("Users: %s\n", userSet.get());
        */

        /*
        //test Lua scripts
        InputStream inputStream = testRedis.class.getClassLoader().getResourceAsStream("test.lua");
        String luaScript = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        String luaSHA = jedis.scriptLoad(luaScript);

        List<String> KEYS = Collections.singletonList(usr);
        List<String> ARGS = Collections.singletonList(usr);
        jedis.evalsha(luaSHA, KEYS, ARGS);

        System.out.printf("%s: %s\n", usr, jedis.get(usr));
        */



    }

    @Test
    @Rollback(value = false)
    public void getSettUnitBySettUnitIdTest() {
        String systemId = "CES";
        String merchantId = "133";
//        Article article = util.getter("1");
//        Article article1 = util.getter("1");
//        boolean flag =(article == article1);
//        System.out.println("THIS IS THE  TEST!!!:   " + flag);
//        util.set("hong1", "24");
//        util.set("kai", "23");
//
//        Object str = util.get("hong1");
//        Object str2 = util.get("hong");
//        Article a = util.getter("1");
//        boolean flag = (str == str2);
//        System.out.println("This is the test: " + flag);


    }

    @Test
    public void testMyself() {
        Integer i = -1281;
        Integer i2 = -1281;
        System.out.println(i.equals(i2));
    }
}
