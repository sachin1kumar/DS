package array;

public class InttoString {
    public static void main(String[] args) {

        String str = Integer.toString(268);

        int count = 0;
        int[] intArray = new int[str.length()+1];

        StringBuffer firstStr = new StringBuffer(str);
        firstStr.append("5");
        System.out.println(firstStr);

        intArray[count] = Integer.parseInt(firstStr.toString());


        for (int i=str.length(); i>0; i--){
            count++;
            //StringBuffer modStr = new StringBuffer(firstStr);
            char ch = firstStr.charAt(i-1); //8
            firstStr.setCharAt(i,ch);
            firstStr.setCharAt(i-1,'5');
            intArray[count] = Integer.parseInt(firstStr.toString());
            System.out.println(firstStr);
        }


      /*  //check array
        for (int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }*/

    }
}
