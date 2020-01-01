package johnny.java.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisExample {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("192.168.182.130");
        System.out.println("Connection to server successfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());

        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));

        //store data in redis list
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);

        for(int i = 0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }

        //store data in redis list
        // Get the stored data and print it
        Set<String> set = jedis.keys("*");

        for (String key : set) {
            System.out.println("List of stored keys:: "+key);
        }
    }
}
