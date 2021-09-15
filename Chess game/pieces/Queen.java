package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Clasa folosita pentru a reprezenta piesa de sah - regina.
 */
public class Queen extends Piece{

    /**
     *
     * @param color - culoarea piesei;
     * pieceType - tipul piesei - "queen";
     */
    public Queen(Color color) {
        super(color, PieceType.queen);
    }

    /**
     * Se folosesc metodele de la nebun si turn, pentru ca regina realizeaza
     * aceleasi miscari.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves, Integer x0, Integer y0, Color turn) {
        Bishop bishop = new Bishop(board.getBoard()[x0][y0].getPiece().getColor());
        Rook rook = new Rook(board.getBoard()[x0][y0].getPiece().getColor());

        return bishop.move(board, moves, x0, y0, turn)
                || rook.move(board, moves, x0, y0, turn);

    }

    public Boolean possibleMoves(Board board, Integer x0, Integer y0, Integer x1, Integer y1) {
        Bishop bishop = new Bishop(board.getBoard()[x0][y0].getPiece().getColor());
        Rook rook = new Rook(board.getBoard()[x0][y0].getPiece().getColor());

        return bishop.possibleMoves(board, x0, y0, x1, y1)
                || rook.possibleMoves(board, x0, y0, x1, y1);
    }
}