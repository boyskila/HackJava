package com.boyko.hack.humanreadablehashmap;

import java.util.HashMap;

public class HumanReadableHashMap {

    static String readMapContent(HashMap<? extends Object, ? extends Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            sb.append(String.format("%s:%s, ", key, value));
        }
        sb.append("}");
        return sb.toString();

    }

}
