import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        int first = map.firstKey();
        TreeMap<Integer, String> tm = new TreeMap<>(Collections.reverseOrder());

        if (first % 2 == 0) {
            int last = map.lastKey();
            tm.putAll(map.subMap(last - 4, last + 1));
        } else {
            tm.putAll(map.subMap(first, first + 5));
        }

        return tm;
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}