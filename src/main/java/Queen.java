/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class Queen extends Piece {

    public Queen(boolean white) {
        super(white);
        this.value = white ? ChessConstants.WHITE_QUEEN : ChessConstants.BLACK_QUEEN;
    }
}
