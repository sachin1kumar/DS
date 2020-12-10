package array;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class JavaTest {
    public static void main(String[] args) {

        int threshold = 3;






        List<String> strings = new ArrayList<>();
        strings.add("9 7 50");
        strings.add("22 7 20");
        strings.add("33 7 50");
        strings.add("22 7 30");

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            String[] splited = str.split("\\s+");
            int firstStr = Integer.parseInt(splited[0]);
            int secondStr = Integer.parseInt(splited[1]);

            boolean isFirstEx = false;
            boolean isSecondEx = false;

            if (!map.containsKey(firstStr)) {
                isFirstEx = true;
                map.put(firstStr, 1);
            }

            if (!map.containsKey(secondStr)) {
                isSecondEx = true;
                map.put(secondStr, 1);
            }

            if (map.containsKey(firstStr) && !isFirstEx) {
                map.put(firstStr, map.get(firstStr) + 1);
            }

            if (map.containsKey(secondStr) && !isSecondEx && !(firstStr == secondStr)) {
                map.put(secondStr, map.get(secondStr) + 1);
            }
        }

            //iterate hashmap.
            // Getting an iterator
            Iterator hmIterator = map.entrySet().iterator();

            // Iterate through the hashmap
            ArrayList<Integer> res = new ArrayList<>();

            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                int value = ((int)mapElement.getValue());
                System.out.println(value+":"+((int)mapElement.getKey()));
                if (value >= threshold) {
                    res.add(((int)mapElement.getKey()));
                }
            }

            Collections.sort(res);

            ArrayList<String> resStr = new ArrayList<>();

            for (int j = 0; j < res.size(); j++){
                System.out.println(res.toString());
                resStr.add(res.toString());
            }



    }
}
