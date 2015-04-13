public class NullKeyValueException extends Exception {

    private final static String WARNING_MASSAGE = "null for key and value is not supported!";

    public NullKeyValueException(String t) {
        super(t);

    }
    public NullKeyValueException(Throwable advice){
        
        super(WARNING_MASSAGE,advice);
    }
}
