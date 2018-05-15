import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by dineshdontha on 5/14/18.
 *
 * This class contains covers all basic test cases for max.allowed pieces on
 * ChessBoard
 *
 * Task 9:
 */
public class BasicChessBoardValidations {

    ChessBoard chessBoard;

    @Before
    public void setUp() {
        chessBoard = new ChessBoard();
    }

    /**
     *incorrect-bishops.txt contains 9 Black Pawn pieces - so should throw IncorrectPiecesException
     */
    @Test
    public void incorrectPawnsCountTest(){
        try{
            chessBoard.initiateChessboardByFiles("incorrect-pawns.txt");
        }catch (IncorrectPiecesException ipe){
            assertEquals("Incorrect number of Black Pawn Pieces",ipe.getMessage());
        }
    }

    /**
     * incorrect-bishops.txt contains 3 White Bishop pieces - so should throw IncorrectPiecesException
     */
    @Test
    public void incorrectBishopsCountTest(){
        try{
            chessBoard.initiateChessboardByFiles("incorrect-bishops.txt");
        }catch (IncorrectPiecesException ipe){
            assertEquals("Incorrect number of White Bishop Pieces",ipe.getMessage());
        }
    }

    /**
     * incorrect-knights.txt contains 3 Black Knights pieces - so should throw IncorrectPiecesException
     */
    @Test
    public void incorrectKnightsCountTest(){
        try{
            chessBoard.initiateChessboardByFiles("incorrect-knights.txt");
        }catch (IncorrectPiecesException ipe){
            assertEquals("Incorrect number of Black Knight Pieces",ipe.getMessage());
        }
    }

    /**
     * incorrect-rooks.txt contains 3 White Rook pieces - so should throw IncorrectPiecesException
     */
    @Test(expected = IncorrectPiecesException.class)
    public void incorrectRooksCountTest(){
            chessBoard.initiateChessboardByFiles("incorrect-rooks.txt");
    }

}
