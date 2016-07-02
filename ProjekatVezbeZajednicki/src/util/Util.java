/*
 * Student: Darko Miloradovic
 * Projektovanje softvera, FON, 2016
 */
package util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Darko
 */
public class Util {

    private Map<String, Object> map;
    private static Util instance;

    public Util() {
        map = new HashMap<>();
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }
}
