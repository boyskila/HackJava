import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseCollection {

    static <T> Collection<T> reverse(Collection<T> collection) {

        Stack<T> stack = new Stack<T>();

        for (T t : collection) {
            stack.push(t);
        }
        collection.clear();
        while (!stack.isEmpty()) {
            collection.add(stack.pop());
        }
        return collection;

        // System.out.println(collection.iterator());
    }

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        numbers.add(3);
        numbers.add(1);
        Iterator<Integer> its = numbers.iterator();
        while (its.hasNext()) {
            System.out.print(its.next());

        }
        reverse(numbers);
        System.out.println();
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());

        }

    }

}
