package codingminutes.string.comparator;

public class Subsequence {

    private String sequence;
    private int length;

    public Subsequence() {

    }

    public Subsequence(String sequence, int length) {
        this.sequence = sequence;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Subsequence{" +
                "sequence='" + sequence + '\'' +
                ", length=" + length +
                '}';
    }
}
