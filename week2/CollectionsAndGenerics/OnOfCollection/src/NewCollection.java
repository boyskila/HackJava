import java.util.Iterator;
import java.util.LinkedList;

public class NewCollection<T> implements NewCollectionInterface<T> {

    private LinkedList<T> collection = new LinkedList<T>();;
    private int counter = 0;

    public NewCollection() {

    }

    @Override
    public void add(T element) {
        if (element != null && !collection.contains(element)) {
            this.collection.add(element);
            counter++;
        } else {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                T t = (T) it.next();
                if (t.equals(element) && !collection.isEmpty()) {
                    collection.removeLastOccurrence(element);
                    counter--;
                }

            }

        }
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public T get(int index) {
        return collection.get(index);
    }

    public static void main(String[] args) {

        NewCollection<Integer> of = new NewCollection<>();
        of.add(3);
        of.add(null);
        of.add(22);
        of.add(22);
        of.add(22);
        for (int i = 0; i < of.size(); i++) {
            System.out.println(of.get(i));
        }

    }
}
