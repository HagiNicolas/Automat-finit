import java.util.ArrayList;

public class ExceptieValidare {
    private ArrayList<String> exceptii;

    public ExceptieValidare() {
        exceptii = new ArrayList<String>();
    }

    public void adaugaExceptie(String ex) {
        exceptii.add(ex);
    }

    public ArrayList<String> verificaExceptii() {
        return exceptii;
    }
}