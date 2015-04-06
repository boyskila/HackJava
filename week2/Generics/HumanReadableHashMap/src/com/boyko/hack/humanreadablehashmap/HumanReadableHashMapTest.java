package com.boyko.hack.humanreadablehashmap;

import java.util.HashMap;
import java.util.Map;

public class HumanReadableHashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        String str = HumanReadableHashMap.readMapContent(map);
        System.out.println(str);
    }

}
