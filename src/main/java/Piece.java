/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class Piece {

    boolean white;
    String value;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "white=" + white +
                ", value='" + value + '\'' +
                '}';
    }
}
