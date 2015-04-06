import java.util.ArrayList;
import java.util.List;

public class BoundedQueue<T> implements Queue<T> {

    private List<T> arr;
    private int capacity;

    public BoundedQueue(int capcity) {
        this.capacity = capcity;
        arr = new ArrayList<>();
    }

    @Override
    public void offer(T e) {
        if (arr.size() < capacity) {
            arr.add(e);
        } else {
            arr.remove(0);
            arr.add(e);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i) + " ");
        }
        return sb.toString();
    }

}
