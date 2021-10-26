package hashmap;

import java.util.HashMap;
import java.util.Map;

public class SortHashMapByValue {
    public static void main(String[] args) {
        Map<String, TestComparator> hashMap = new HashMap<>();
        hashMap.put("Sachin", new TestComparator(22, "test22"));
        hashMap.put("Wes", new TestComparator(1, "test1"));
        hashMap.put("Bead", new TestComparator(20, "test20"));

        System.out.println(hashMap.toString());
    }
}
