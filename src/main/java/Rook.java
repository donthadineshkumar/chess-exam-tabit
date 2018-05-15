/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
        this.value = white ? ChessConstants.WHITE_ROOK : ChessConstants.BLACK_ROOK;
    }
}
