package array;

import java.util.*;

public class SortHashMapValues {

    public static void main(String[] args) {
        //int[] arr = {5,5,4,6,4};
        int[] arr = {9,9,9,2,5};

        //Storing the frequency of above elements in hashmap..
        HashMap<Integer, Integer> map = storeFrequencyOfElementsInMap(arr);

        //convert hashmap to AL..
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(map.entrySet());

        //Sort the AL in descending order w.r.t values. So, implementing Comparator..
        Collections.sort(arrayList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        //Store the sorted AL's elements in Linked HashMap..
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry: arrayList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        //print linkedHashMap..
        for (Map.Entry<Integer, Integer> entry: linkedHashMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        //Output of this problem
        int currentFreq = 0;
        int prevElement = arr[0];
        ArrayList<Integer> output = new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            int freq = map.get(arr[index]);
            if (freq >= currentFreq && arr[index] <= prevElement) {
                output.add(0, arr[index]);
            } else {
                output.add(output.size() , arr[index]);
            }
            currentFreq = freq;
            prevElement = arr[index];
        }

        //Iterate output..
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i)+" ");
        }
    }

    private static HashMap<Integer,Integer> storeFrequencyOfElementsInMap(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        return map;
    }
}
