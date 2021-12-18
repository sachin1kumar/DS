package codingminutes.util;

public class CustomPair implements Comparable<CustomPair> {
    private int key;
    private int value;

    public CustomPair() {

    }

    public CustomPair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(CustomPair o) {
        if (this.key > o.key) {
            return 1;
        } else if (this.key < o.key) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "CustomPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
