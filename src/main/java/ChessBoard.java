import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dineshdontha on 5/14/18.
 *
 * This class is a central class for this project. Here, initialize the ChessBoard,
 * Reading the Chess situation from a file, & write a Chess Situation to a file operations are defined.
 *
 * Task 1:
 */
public class ChessBoard {
    static Square[][] squares = new Square[8][8];
    static Map<String, Integer> pieceWiseCount;

    //Task 2
    public static void initializeChessboard(){
        for(int i=7; i >= 0 ; i--){
            for(int j=0; j <= 7 ; j++){
                if(i==7){
                    squares[i][0] = new Square(i,j,new Rook(false));
                    squares[i][1] = new Square(i,j,new Knight(false));
                    squares[i][2] = new Square(i,j,new Bishop(false));
                    squares[i][3] = new Square(i,j,new Queen(false));
                    squares[i][4] = new Square(i,j,new King(false));
                    squares[i][5] = new Square(i,j,new Bishop(false));
                    squares[i][6] = new Square(i,j,new Knight(false));
                    squares[i][7] = new Square(i,j,new Rook(false));
                }else if(i==6){
                    squares[i][j] = new Square(i,j,new Pawn(false));
                } else if(i==1){
                    squares[i][j] = new Square(i,j,new Pawn(true));
                }else if(i==0){
                    squares[i][0] = new Square(i,j,new Rook(true));
                    squares[i][1] = new Square(i,j,new Knight(true));
                    squares[i][2] = new Square(i,j,new Bishop(true));
                    squares[i][3] = new Square(i,j,new Queen(true));
                    squares[i][4] = new Square(i,j,new King(true));
                    squares[i][5] = new Square(i,j,new Bishop(true));
                    squares[i][6] = new Square(i,j,new Knight(true));
                    squares[i][7] = new Square(i,j,new Rook(true));
                }else{
                    squares[i][j] = new Square(i,j,null);
                }
            }
        }
    }

    //Task 6
    public static void writeChessboardToFile(String filename) throws IOException {
        StringBuffer chessboardSituation = new StringBuffer();
        for(int i=7; i >= 0 ; i--){
            chessboardSituation = chessboardSituation.append((i+1)+" ");
            for(int j=0; j <= 7 ; j++){
                String pieceValue = squares[i][j].getPiece()!=null ? squares[i][j].getPiece().getValue() : "  ";
                chessboardSituation.append("|").append(pieceValue);
            }
            chessboardSituation.append("|").append("\r\n");
        }
        chessboardSituation.append("   a  b  c  d  e  f  g  h").append("\r\n");

        try(PrintWriter writer = new PrintWriter("src/test/resources/"+filename,"UTF-8")) {
                writer.write(chessboardSituation.toString().trim());
        }
    }

    //Task 4
    public static void initiateChessboardByFiles(String filename){
        pieceWiseCount = new HashMap<String, Integer>();
        File file = new File("src/test/resources/"+filename);
        try (Scanner sc = new Scanner(file, "UTF-8")) {
            int col = 0;
            int row = 7;
            int startIndex = 0;
            String currPieceVal = "";
            String currLine = "";
            while(sc.hasNextLine() && row >= 0){
                currLine = sc.nextLine();
                for(int k=1; k<=8; k++){
                     startIndex = 3 * k;
                     currPieceVal = getCurrPieceVal(currLine, startIndex);
                     squares[row][k-1] = new Square(row, k-1, getCurrPieceObject(currPieceVal));
                }
                row -= 1;
            }
            checkBasicValidations();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Task 8
    private static void checkBasicValidations() {
        Map<String, Integer> pieceCounts = pieceWiseCount;
        if(pieceCounts.get(ChessConstants.BLACK_ROOK).intValue() > 2)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"Black Rook"));
        else if(pieceCounts.get(ChessConstants.WHITE_ROOK).intValue() > 2)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"White Rook"));
        else if(pieceCounts.get(ChessConstants.BLACK_KNIGHT).intValue() > 2)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"Black Knight"));
        else if(pieceCounts.get(ChessConstants.WHITE_KNIGHT).intValue() > 2)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"White Knight"));
        else if(pieceCounts.get(ChessConstants.BLACK_BISHOP).intValue() > 2)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"Black Bishop"));
        else if(pieceCounts.get(ChessConstants.WHITE_BISHOP).intValue() > 2)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"White Bishop"));
        else if(pieceCounts.get(ChessConstants.BLACK_QUEEN).intValue() > 1)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"Black Queen"));
        else if(pieceCounts.get(ChessConstants.WHITE_QUEEN).intValue() > 1)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"White Queen"));
        else if(pieceCounts.get(ChessConstants.BLACK_KING).intValue() > 1)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"Black King"));
        else if(pieceCounts.get(ChessConstants.WHITE_KING).intValue() > 1)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"White King"));
        else if(pieceCounts.get(ChessConstants.BLACK_PAWN).intValue() > 8)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"Black Pawn"));
        else if(pieceCounts.get(ChessConstants.WHITE_PAWN).intValue() > 8)
            throw new IncorrectPiecesException(String.format(ChessConstants.INCORRECT_PIECES_EX_MSG,"White Pawn"));
    }

    private static Piece getCurrPieceObject(String currPieceVal) {
        switch (currPieceVal) {
            case ChessConstants.BLACK_ROOK :
                incrementPieceCount(ChessConstants.BLACK_ROOK);
                return new Rook(false);
            case ChessConstants.WHITE_ROOK :
                incrementPieceCount(ChessConstants.WHITE_ROOK);
                return new Rook(true);
            case ChessConstants.BLACK_KNIGHT :
                incrementPieceCount(ChessConstants.BLACK_KNIGHT);
                return new Knight(false);
            case ChessConstants.WHITE_KNIGHT :
                incrementPieceCount(ChessConstants.WHITE_KNIGHT);
                return new Knight(true);
            case ChessConstants.BLACK_BISHOP :
                incrementPieceCount(ChessConstants.BLACK_BISHOP);
                return new Bishop(false);
            case ChessConstants.WHITE_BISHOP :
                incrementPieceCount(ChessConstants.WHITE_BISHOP);
                return new Bishop(true);
            case ChessConstants.BLACK_QUEEN :
                incrementPieceCount(ChessConstants.BLACK_QUEEN);
                return new Queen(false);
            case ChessConstants.WHITE_QUEEN :
                incrementPieceCount(ChessConstants.WHITE_QUEEN);
                return new Queen(true);
            case ChessConstants.BLACK_KING :
                incrementPieceCount(ChessConstants.BLACK_KING);
                return new King(false);
            case ChessConstants.WHITE_KING :
                incrementPieceCount(ChessConstants.WHITE_KING);
                return new King(true);
            case ChessConstants.BLACK_PAWN :
                incrementPieceCount(ChessConstants.BLACK_PAWN);
                return new Pawn(false);
            case ChessConstants.WHITE_PAWN :
                incrementPieceCount(ChessConstants.WHITE_PAWN);
                return new Pawn(true);
            default:
                return null;
        }

    }

    private static void incrementPieceCount(String currPiece) {
        int currPieceVal = pieceWiseCount.get(currPiece) != null ? pieceWiseCount.get(currPiece) : 0;
        pieceWiseCount.put(currPiece, currPieceVal+1);
    }

    private static String getCurrPieceVal(String currLine, int startIndex) {
        return currLine.substring(startIndex, startIndex+2);
    }

}
