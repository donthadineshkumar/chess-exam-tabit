import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by dineshdontha on 5/14/18.
 *
 * This class covers the test cases related to initializing ChessBoard
 * using start-up conditions or using some chess situations read from
 * file.
 *
 * Task 5: Write at least 4 Unit tests to check that the
 * functionality of reading the txt files and initiating the ChessBoard works
 * (please use the 4 given txt files)
 */
public class ChessBoardInitiationTests {

    ChessBoard chessBoard;

    @Before
    public void setUp(){
        chessBoard = new ChessBoard();
    }

    /**
     * Test for basic initialize of ChessBoard with all pieces in their
     * default positions
     */
    @Test
    public void initiateChessBoardTest(){
        chessBoard.initializeChessboard();
        Square[][] loadedChessboard = chessBoard.squares; //indexed from 0 to 7
        assertionsForChessboardStartup(loadedChessboard);
    }

    /**
     * Test for basic initialize of ChessBoard by reading chess-startup.txt file
     */
    @Test
    public void initiateChessBoardByChessStartupFileTest(){
        chessBoard.initiateChessboardByFiles("chess-startup.txt");
        Square[][] loadedChessboard = chessBoard.squares; //indexed from 0 to 7
        assertionsForChessboardStartup(loadedChessboard);
    }

    /**
     * Test for initializing ChessBoard with a chess situation in chess-01.txt
     */
    @Test
    public void initiateChessBoardByChess01FileTest(){
        chessBoard.initiateChessboardByFiles("chess-01.txt");
        Square[][] loadedChessboard = chessBoard.squares; //indexed from 0 to 7

        //Count of White Pawns should be only 7 as in chess-01.txt file
        Map<String, Integer> counts = chessBoard.pieceWiseCount;
        assertEquals(7, counts.get(ChessConstants.WHITE_PAWN).intValue());

        //check the position of White Queen - h5(4,7)
        assertTrue(ChessConstants.WHITE_QUEEN.equals(loadedChessboard[4][7].getPiece().getValue()));
    }

    /**
     * Test for initializing ChessBoard with a chess situation in chess-02.txt
     */
    @Test
    public void initiateChessBoardByChess02FileTest(){
        chessBoard.initiateChessboardByFiles("chess-02.txt");
        Square[][] loadedChessboard = chessBoard.squares; //indexed from 0 to 7

        //Count of White Pawns should be only 6 as in chess-02.txt file
        Map<String, Integer> counts = chessBoard.pieceWiseCount;
        assertEquals(6, counts.get(ChessConstants.WHITE_PAWN).intValue());

        //the left-upper corner & right-lower corners are empty - no pieces - a8(7,0) & h1(0,7)
        assertNull(loadedChessboard[7][0].getPiece());
        assertNull(loadedChessboard[0][7].getPiece());
    }

    /**
     * Test for initializing ChessBoard with a chess situation in chess-03.txt
     */
    @Test
    public void initiateChessBoardByChess03FileTest(){
        chessBoard.initiateChessboardByFiles("chess-03.txt");
        Square[][] loadedChessboard = chessBoard.squares; //indexed from 0 to 7

        //Count of Black Pawns should be only 3 as in chess-03.txt file
        Map<String, Integer> counts = chessBoard.pieceWiseCount;
        assertEquals(3, counts.get(ChessConstants.BLACK_PAWN).intValue());

        //the left-upper corner & right-lower corners are empty - no pieces - a8(7,0) & h1(0,7)
        assertNull(loadedChessboard[7][0].getPiece());
        assertNull(loadedChessboard[0][7].getPiece());

        //Only one White Bishop should be there in position - e3(2,4)
        assertEquals(1, counts.get(ChessConstants.WHITE_BISHOP).intValue());
        assertTrue(ChessConstants.WHITE_BISHOP.equals(loadedChessboard[2][4].getPiece().getValue()));
    }

    private void assertionsForChessboardStartup(Square[][] loadedChessboard) {
        //assertion: position a7(6,0) should be a Black Pawn & g2(1,6) should be a White Pawn
        assertTrue(ChessConstants.BLACK_PAWN.equals(loadedChessboard[6][0].getPiece().getValue()));
        assertTrue(ChessConstants.WHITE_PAWN.equals(loadedChessboard[1][6].getPiece().getValue()));

        //assertion: position e8(7,4) should be a Black King & d1(0,3) should be a White Queen
        assertTrue(ChessConstants.BLACK_KING.equals(loadedChessboard[7][4].getPiece().getValue()));
        assertTrue(ChessConstants.WHITE_QUEEN.equals(loadedChessboard[0][3].getPiece().getValue()));

        /** assertion: position a8(7,0) should be a Black Rook, b1(0,1) should be a White Knight
            & c8(7,2) should be a Black Bishop
         */
        assertTrue(ChessConstants.BLACK_ROOK.equals(loadedChessboard[7][0].getPiece().getValue()));
        assertTrue(ChessConstants.WHITE_KNIGHT.equals(loadedChessboard[0][1].getPiece().getValue()));
        assertTrue(ChessConstants.BLACK_BISHOP.equals(loadedChessboard[7][2].getPiece().getValue()));
    }



}
