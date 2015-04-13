import java.util.HashMap;

public class NewHashMap<K, V> extends HashMap<K, V> {

    private boolean flag = false;

    public NewHashMap() {
        super();
    }

    @Override
    public V put(K key, V value) {

        if (flag) {
            if (key == null || value == null) {
                try {
                    throw new NullKeyValueException(new NullKeyValueException(
                            "Solution ==> call the switchNull method from NewHashMap class"));
                } catch (NullKeyValueException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
        return super.put(key, value);
    }

    public void switchNull(boolean flag) {
        this.flag = flag;
    }

    @Override
    public V get(Object object) {
        if (flag && object == null) {

            try {
                throw new NullKeyValueException(new NullKeyValueException(
                        "Solution ==> call the switchNull method from NewHashMap class"));
            } catch (NullKeyValueException e) {

                e.printStackTrace();
            }

            System.exit(0);
        }
        return super.get(object);
    }

}
