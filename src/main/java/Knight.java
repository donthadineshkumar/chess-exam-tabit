/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
        this.value = white ? ChessConstants.WHITE_KNIGHT : ChessConstants.BLACK_KNIGHT;
    }
}
