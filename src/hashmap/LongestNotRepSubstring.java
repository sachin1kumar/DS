package hashmap;

import java.util.HashMap;

public class LongestNotRepSubstring {

    public static int max_len = 0;

    public static void main(String[] args) {

        System.out.println(lengthOfSubstring("bbbbccce"));
    }

    private static int lengthOfSubstring(String str) {
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            System.out.println("i1="+i);
            if(!hashMap.containsKey(ch)){
                hashMap.put(ch,i);
            }
            else{
                i = hashMap.get(ch);
                System.out.println("i2="+i);
                hashMap.clear();
            }

            if(hashMap.size() > max_len){
                max_len = hashMap.size();
            }
            System.out.println("i3="+i);
            System.out.println(hashMap.keySet().toString());
        }

        return max_len;
    }


}
