import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by dineshdontha on 5/14/18.
 *
 * This class covers all the test cases related to writing
 * the ChessBoard situations to a new File.
 *
 * Task 7:
 */
public class WriteChessSituationToFileTests {

    ChessBoard chessBoard;

    @Before
    public void setUp(){
        chessBoard = new ChessBoard();
    }

    /**
     * creates chess-write-1.txt file & writes a basic startup situation to this
     * newly created file
     */
    @Test
    public void writeChessStartupSituationToFileTest() throws IOException {
        chessBoard.initializeChessboard();
        chessBoard.writeChessboardToFile("chess-write-1.txt");
        File file = new File("src/test/resources/chess-write-1.txt");
        assertTrue(file.exists());
    }

    /**
     * creates chess-write-2.txt file & writes a situation to this newly created
     * file
     */
    @Test
    public void writeChessSituationToFileTest() throws IOException {
        chessBoard.initiateChessboardByFiles("chess-03.txt");
        chessBoard.writeChessboardToFile("chess-write-2.txt");
        File file = new File("src/test/resources/chess-write-2.txt");
        assertTrue(file.exists());
    }

    /**
     * creates chess-write-3.txt file & also creates a new situation by initializing
     * the Java Objects & then saves those into this newly created file
     */
    @Test
    public void createChessSituationAndStoreToFileTest() throws IOException {
        createChessSituation();
        chessBoard.writeChessboardToFile("chess-write-3.txt");
        File file = new File("src/test/resources/chess-write-3.txt");
        assertTrue(file.exists());
    }

    private void createChessSituation() {
        for(int i=7; i >= 0 ; i--) {
            for (int j = 0; j <= 7; j++) {
                chessBoard.squares[i][j] = new Square(7,3, null);
            }
        }
        chessBoard.squares[7][3] = new Square(7,3, new King(false));
        chessBoard.squares[7][7] = new Square(7,7, new Rook(false));
        chessBoard.squares[4][7] = new Square(4,7, new Queen(true));
        chessBoard.squares[2][4] = new Square(2,4, new Bishop(true));
        chessBoard.squares[0][0] = new Square(0,0, new Rook(true));
    }

}
