package johnny.java.advanced.weakhashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapGCExample {
    public static void main(String args[])throws Exception {
        Map<Resource, String> map = new HashMap<>();
        Resource r = new Resource();

        // puts an entry into HashMap
        map.put(r, "Hi");

        System.out.println(map);
        r = null;

        // garbage collector is called
        System.gc();

        //thread sleeps for 4 sec
        Thread.sleep(4000);

        System.out.println(map);
    }
}
