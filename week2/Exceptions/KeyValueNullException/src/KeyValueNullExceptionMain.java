import java.util.Map;

public class KeyValueNullExceptionMain {

    public static void main(String[] args) throws NullKeyValueException {

        NewHashMap<Integer, String> map = new NewHashMap<>();
        map.switchNull(false); // throw NullKeyValueException if
        // switchNull is true
        map.put(1, "Kush");
        map.put(2, "Kush");
        map.put(3, "Kush");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(null));

        NewHashMap<Integer, String> mapp = new NewHashMap<>();
        mapp.switchNull(true); // throw NullKeyValueException if
        // switchNull is true
        mapp.put(1, "Kush");
        mapp.put(2, "Kush");
        mapp.put(3, "Kush");
        System.out.println(mapp.get(1));
        System.out.println(mapp.get(2));
        System.out.println(mapp.get(null));

    }
}
