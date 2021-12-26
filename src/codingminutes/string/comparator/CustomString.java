package codingminutes.string.comparator;

import java.util.Comparator;

public class CustomString implements Comparator<CustomString> {

    private String string;

    public CustomString() {

    }

    public CustomString(String string) {
        this.string = string;
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int compare(CustomString o1, CustomString o2) {
        String str1 = o1.getString() + o2.getString();
        String str2 = o2.getString() + o1.getString();
        return str1.compareTo(str2);
    }
}
