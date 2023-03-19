package week3.datedMap;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class DatedMapImpl implements DatedMap {
    private final Map<String, String> map = new HashMap<>();
    private final Map<String, Date> keyLastInsertionDate = new HashMap<>();

    @Override
    public void put(String key, String value) {
        map.put(key, value);
        keyLastInsertionDate.put(key, new Date());
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
        keyLastInsertionDate.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        return keyLastInsertionDate.get(key);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
