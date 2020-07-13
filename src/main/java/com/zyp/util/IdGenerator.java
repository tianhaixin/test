package com.zyp.util;

import java.util.HashMap;
import java.util.Map;

/**
 * id生成器（获取新的id）
 * 
 * @author Zyp
 *
 */
public class IdGenerator {
    static private Map<String, Long> map = new HashMap<>();
    static public final String TRADE_ID_KEY = "tradeId";

    /**
     * 
     * @param key
     * @return
     */
    static public long getNewId(String key) {
        if (map.get(key) == null) {
            map.put(key, 0L);
        }

        Long lastId = map.get(key);

        return ++lastId;
    }
}
