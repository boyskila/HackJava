import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RotateCollection {

    static <T> Collection<T> rotate(Collection<T> collection, int rotateStep) {

        Deque<T> q = new LinkedList<T>();
        q.addAll(collection);

        collection.clear();

        while (rotateStep != 0) {
            if (rotateStep > 0) {
                rotateStep--;
                q.addFirst(q.pollLast());
            } else {
                rotateStep++;
                q.addLast(q.pollFirst());
            }

        }
        collection.addAll(q);
        return collection;
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven"));
        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("before rotation");
        for (String str : list) {
            System.out.print(str + "--");
        }
        System.out.println();
        System.out.println("after rotation");
        for (String str : rotate(list, -2)) {
            System.out.print(str + "--");
        }
        System.out.println();
        System.out.println("before rotation");
        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            int integer = it.next();
            System.out.print(integer + "--");
        }

        System.out.println("\nafter rotation");
        Iterator<Integer> iterator = rotate(intList, 2).iterator();
        while (iterator.hasNext()) {
            int integer = iterator.next();
            System.out.print(integer + "--");
        }

    }

}
