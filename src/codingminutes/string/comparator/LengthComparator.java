package codingminutes.string.comparator;

import java.util.Comparator;

public class LengthComparator implements Comparator<Subsequence> {

    @Override
    public int compare(Subsequence o1, Subsequence o2) {
        return o1.getLength() - o2.getLength();
    }
}
