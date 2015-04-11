public class WcResult {

    private int rows;
    private int words;
    private int symbols;

    public WcResult(int rows, int words, int symbols) {
        this.rows = rows;
        this.words = words;
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "WcResult [rows=" + rows + ", words=" + words + ", symbols=" + symbols + "]";
    }

}
