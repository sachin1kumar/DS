package array;

public class DayOfProgrammer {
    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1800));
    }

    private static String dayOfProgrammer(int year){
        int noOfLeapDays = 244;
        int noOfNonLeapDays = 243;
        int diff = 0;

        int julianoOfLeapDays = 231;
        int julianoOfNonLeapDays = 230;

        if(1700 <= year && year <= 1918){
            if(year % 4 == 0){
                diff = 256 - noOfLeapDays;
            } else {
                diff = 256 - noOfNonLeapDays;
            }
        } else {
            if (year % 400 == 0 ||(year % 4 == 0 && year % 100 != 0)){
                diff = 256 - noOfLeapDays;
            } else {
                diff = 256 - noOfNonLeapDays;
            }
        }

        return convertToString(diff, year);
    }

    private static String convertToString(int diff, int year) {
        return diff+"."+"09"+"."+year;
    }

}
