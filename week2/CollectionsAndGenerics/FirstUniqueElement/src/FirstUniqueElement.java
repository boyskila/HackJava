import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUniqueElement {
    static Integer findFirstUniqueElement(Collection<Integer> collection) {

        Map<Integer, Integer> scoreboard = new HashMap<>();

        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {

            int i = it.next();

            if (scoreboard.containsKey(i)) {
                scoreboard.put(i, scoreboard.get(i) + 1);
            } else {
                scoreboard.put(i, 1);
            }
        }

        Iterator<Integer> iter = collection.iterator();
        while (iter.hasNext()) {

            int i = iter.next();

            if (scoreboard.get(i) == 1) {
                return i;
            }
        }

        throw new RuntimeException();

    }

    public static void main(String[] args) {
        Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 7, 1);
        System.out.println(findFirstUniqueElement(ints));

    }

}
