package codingminutes.priorityqueue.findingcabs;

import java.util.Comparator;

public class Cab implements Comparator<Cab> {
    private String id;
    private int x;
    private int y;
    private int distance;

    public Cab() {

    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int compare(Cab o1, Cab o2) {
        return o1.distance - o2.distance;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setId(String id) {
        this.id = id;
    }
}
