package hashmap;

public class TestComparator implements Comparable<TestComparator> {
    private final int id;
    private final String name;

    public TestComparator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(TestComparator o) {
        if (id == o.id) {
            return 0;
        } else if(id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "TestComparator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
