/**
 * Created by dineshdontha on 5/14/18.
 *
 * This exception is thrown when basic validations like "Incorrect number" of
 * pieces added on to ChessBoard.
 *
 * Task 7:
 */
public class IncorrectPiecesException extends RuntimeException {
    public IncorrectPiecesException(String message) {
        super(message);
    }
}
