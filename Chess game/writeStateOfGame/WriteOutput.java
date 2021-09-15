package writeStateOfGame;

import board.Board;
import pieces.Piece;
import pieces.PieceType;

import java.io.FileWriter;
import java.io.IOException;

public class WriteOutput {

    public FileWriter output;

    public WriteOutput() throws IOException {
        this.output = new FileWriter("output.txt");
    }


    public void writeMessage(String s) throws IOException {
        output.write(s + "\n");
    }

    public void writeBoard(Board board) throws IOException {

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    if (board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.queen)) {
                        output.write("Q ");
                    }

                    if (board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.king)) {
                        output.write("K ");
                    }

                    if (board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.bishop)) {
                        output.write("B ");
                    }

                    if (board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.pawn)) {
                        output.write("P ");
                    }

                    if (board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.rook)) {
                        output.write("R ");
                    }

                    if (board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.knight)) {
                        output.write("H ");
                    }
                } else {
                    output.write("* ");
                }
            }
            output.write("\n");
        }

        output.write("\n");
    }

    public void close() throws IOException {
        output.close();
    }

}
