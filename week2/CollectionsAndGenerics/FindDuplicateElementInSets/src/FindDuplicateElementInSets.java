import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindDuplicateElementInSets {

    static Set<Integer> returnDuplicate(Set<Integer> A, Set<Integer> B, Set<Integer> C) {

        List<Integer> tempResult = new ArrayList<>();
        Set<Integer> finalResult = new HashSet<>();
        Map<Integer, Integer> score = new HashMap<>();

        tempResult.addAll(A);
        tempResult.addAll(B);
        tempResult.addAll(C);

        Iterator<Integer> it = tempResult.iterator();
        while (it.hasNext()) {

            int i = it.next();

            if (score.containsKey(i)) {
                score.put(i, score.get(i) + 1);
            } else {
                score.put(i, 1);
            }
        }

        Iterator<Integer> iter = tempResult.iterator();
        while (iter.hasNext()) {

            int i = iter.next();

            if (score.get(i) > 1) {
                finalResult.add(i);
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {

        Set<Integer> A = new HashSet<>(Arrays.asList(5, 6, 7, 8));
        Set<Integer> B = new HashSet<>(Arrays.asList(5, 2, 3, 1));
        Set<Integer> C = new HashSet<>(Arrays.asList(5, 4, 9, 10));

        Iterator<Integer> it = returnDuplicate(A, B, C).iterator();
        while (it.hasNext()) {

            System.out.println(it.next());

        }
    }
}
