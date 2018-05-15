/**
 * Created by dineshdontha on 5/14/18.
 *
 * Task 1:
 */
public class Pawn extends Piece{

    public Pawn(boolean white) {
        super(white);
        this.value = white ? ChessConstants.WHITE_PAWN : ChessConstants.BLACK_PAWN;
    }
}
