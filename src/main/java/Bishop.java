/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white);
        this.value = white ? ChessConstants.WHITE_BISHOP : ChessConstants.BLACK_BISHOP;
    }
}
