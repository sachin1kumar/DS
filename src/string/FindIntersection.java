package string;

import java.util.LinkedHashSet;

public class FindIntersection {

    public static void main(String[] args) {
        String[] input = new String[]{"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        String str1 = input[0];
        String str2 = input[1];

        //split the strings into string array..
        String[] strArr1 = str1.split(",");
        String[] strArr2 = str2.split(",");

        //store StrArr2 in LinkedHashSet..
        LinkedHashSet<String> set = addToSet(strArr2);

        StringBuilder output = new StringBuilder("");

        //iterate StrArr1...
        for (int i = 0; i < strArr1.length; i++) {
            String filteredStr = strArr1[i].trim();
            if (set.contains(filteredStr)) {
                output.append(Integer.parseInt(filteredStr) + ",");
            }
        }
        //remove , from the last index..

        output.deleteCharAt(output.length() - 1);
        output.toString();
    }

    private static LinkedHashSet<String> addToSet(String[] strArr2) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < strArr2.length; i++) {
            System.out.println(strArr2[i].trim());
            set.add(strArr2[i].trim());
        }
        return set;
    }
}
