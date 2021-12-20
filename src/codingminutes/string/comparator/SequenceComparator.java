package codingminutes.string.comparator;

import java.util.Comparator;

public class SequenceComparator implements Comparator<Subsequence> {

    @Override
    public int compare(Subsequence o1, Subsequence o2) {
        return o1.getSequence().compareTo(o2.getSequence());
    }
}
