package array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SortDateArray {

    public static void main(String[] args) {
        //Given date in string format..
        ArrayList<String> strDateList = initList();
        //convert string date to date
        ArrayList<Date> dateArrayList = convertToDate(strDateList);
        //Sort the date ArrayList..
        ArrayList<Date> sortedDateList = sortDateList(dateArrayList);
        //print the sorted date list..
        printSortedDateList(sortedDateList);
        //print the sorted data list in string format..
        printSortedDateListInString(sortedDateList);
    }

    private static ArrayList<String> initList() {
        ArrayList<String> date = new ArrayList<>();
        date.add("21/12/1998");
        date.add("20/12/1998");
        date.add("11/12/1997");
        return date;
    }

    private static ArrayList<Date> convertToDate(ArrayList<String> strDate) {
        ArrayList<Date> dateList = new ArrayList<>();
        for (String s : strDate) {
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(s);
                dateList.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dateList;
    }

    private static ArrayList<Date> sortDateList(ArrayList<Date> dateArrayList) {
        dateArrayList.sort(new CustomComparator());
        return dateArrayList;
    }

    private static void printSortedDateList(ArrayList<Date> dateArrayList) {
        for (Date date : dateArrayList) {
            System.out.println(date);
        }
    }

    private

    static class CustomComparator implements Comparator<Date> {
        @Override
        public int compare(Date o1, Date o2) {
            //For year.
            if (o1.getYear() > o2.getYear()) {
                return 1;
            } else if (o1.getYear() < o2.getYear()) {
                return -1;
            }
            //for month.
            if (o1.getMonth() > o2.getMonth()) {
                return 1;
            } else if (o1.getMonth() < o2.getMonth()) {
                return -1;
            }
            //for day.
            if (o1.getDay() > o2.getDay()) {
                return 1;
            } else if (o1.getDay() < o2.getDay()) {
                return -1;
            }
            return 0;
        }
    }

    private static void printSortedDateListInString(ArrayList<Date> sortedDateList) {
        for (Date date: sortedDateList) {
            //convert date to String format.
            int sDate = date.getDate();
            int sMonth = date.getMonth() + 1;
            int sYear = date.getYear();
            System.out.println(sDate+"/"+sMonth+"/"+sYear);
        }
    }
}
