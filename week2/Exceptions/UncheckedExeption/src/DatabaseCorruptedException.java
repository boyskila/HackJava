public class DatabaseCorruptedException extends Exception {

    private final static String DEFAULT_MASSAGE = "The DataBase was corrupted because of invalid username";

    DatabaseCorruptedException() {

    }

    public DatabaseCorruptedException(String message) {
        super(message);
    }

    public DatabaseCorruptedException(Throwable advice) {
        super(DEFAULT_MASSAGE,advice);
    }
}
