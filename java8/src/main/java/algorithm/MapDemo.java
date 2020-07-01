package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/6/16 17:37
 */
public class MapDemo {

    public static void main(String[] args) {
        // Map<Integer, String> map = new TreeMap();

        String abc = "google";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0, len = abc.length(); i < len; i++) {
            char c = abc.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (value == 1){
                System.out.println(key);
                break;
            }

        }

    }
}
