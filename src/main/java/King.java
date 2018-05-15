/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class King extends Piece {

    public King(boolean white) {
        super(white);
        this.value = white ? ChessConstants.WHITE_KING : ChessConstants.BLACK_KING;
    }
}
