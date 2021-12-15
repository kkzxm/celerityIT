package com.lingDream.celerityIT.tool.cache;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class Cache {
    // 一种数据类型装入一个位置
    private final List<Map<String, Object>> cacheMapList = new ArrayList<>();

    /**
     * @param tClass 装入数据的数据类型
     * @param key    唯一键
     * @param value  装入的值
     */
    public <T> void put(Class<T> tClass, String key, Object value) {
        Map<String, Object> mapByClass = getMapByClass(tClass);
        if (mapByClass != null) {
            mapByClass.put(key, value);
        } else {
            cacheMapList.add(new Hashtable<String, Object>() {{
                put(key, value);
            }});
        }
    }

    /**
     * 检查某个值是否存在
     */
    public <T> Object checkKeyExists(Class<T> tClass, String key) {
        Map<String, Object> mapByClass = getMapByClass(tClass);
        if (mapByClass != null) {
            return mapByClass.get(key);
        }
        return null;
    }

    /**
     * 根据数据类型查找缓存Map
     */
    public <T> Map<String, Object> getMapByClass(Class<T> tClass) {
        for (Map<String, Object> map : cacheMapList) {
            for (String s : map.keySet()) {
                if (map.get(s).getClass().equals(tClass)) {
                    return map;
                }
                break;
            }
        }
        return null;
    }
}
