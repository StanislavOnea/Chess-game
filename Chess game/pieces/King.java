package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Clasa folosita pentru a reprezenta piesa de sah - regele.
 */
public class King extends Piece{
    private boolean firstMove = true;

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    /**
     *
     * @param color - culoarea piesei;
     * pieceType - tipul piesei - "king";
     */


    public King(Color color) {
        super(color, PieceType.king);
    }

    /**
     * Metoda in care se adauga miscarile care pot fi realizate cu regele
     * de culoarea cu care joaca botul, in moves, sau daca regele adversar
     * ii da sah regelui cu care joaca botul.
     *
     * Se verifica pentru fiecare pozitie in care poate si mutat regele,
     * daca e goala sau e o piesa a adversarului.
     *
     * Daca regele are culoarea cu care joaca adversarul, atunci se verifica
     * daca ii da sah regelui botului. Se retunreaza true in acest caz.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves,
                                    Integer x0, Integer y0, Color pieceColor) {
        boolean canMove = false;
        if (board.getBoard()[x0][y0].getPiece().getColor() == pieceColor) {
            canMove = true;
        }
        if (x0 + 1 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 + 1][y0].getPiece() == null
                        || (board.getBoard()[x0 + 1][y0].getPiece() != null
                        && !board.getBoard()[x0 + 1][y0].getPiece()
                            .getColor().equals(pieceColor))) {
                    moves.add(new AviableMove(x0, y0, x0 + 1, y0));
                }
            } else {

                if (board.getBoard()[x0 + 1][y0].getPiece() != null
                    && board.getBoard()[x0 + 1][y0].getPiece().
                        getColor().equals(pieceColor)
                    && board.getBoard()[x0 + 1][y0].getPiece()
                        .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (x0 - 1 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 - 1][y0].getPiece() == null
                        || (board.getBoard()[x0 - 1][y0].getPiece() != null
                        && !board.getBoard()[x0 - 1][y0].getPiece()
                            .getColor().equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0 - 1, y0));

                }
            } else {

                if (board.getBoard()[x0 - 1][y0].getPiece() != null
                        && board.getBoard()[x0 - 1][y0].getPiece()
                            .getColor().equals(pieceColor)
                        && board.getBoard()[x0 - 1][y0].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (y0 + 1 < 8) {
            if (canMove) {
                if (board.getBoard()[x0][y0 + 1].getPiece() == null
                        || (board.getBoard()[x0][y0 + 1].getPiece() != null
                        && !board.getBoard()[x0][y0 + 1].getPiece().getColor()
                            .equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0, y0 + 1));
                }
            } else {

                if (board.getBoard()[x0][y0 + 1].getPiece() != null
                        && board.getBoard()[x0][y0 + 1].getPiece()
                            .getColor().equals(pieceColor)
                        && board.getBoard()[x0][y0 + 1].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (y0 - 1 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0][y0 - 1].getPiece() == null
                        || (board.getBoard()[x0][y0 - 1].getPiece() != null
                        && !board.getBoard()[x0][y0 - 1].getPiece().
                            getColor().equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0, y0 - 1));
                }
            } else {

                if (board.getBoard()[x0][y0 - 1].getPiece() != null
                        && board.getBoard()[x0][y0 - 1].getPiece()
                            .getColor().equals(pieceColor)
                        && board.getBoard()[x0][y0 - 1].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }


        if (x0 + 1 < 8 && y0 - 1 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 + 1][y0 - 1].getPiece() == null
                        || (board.getBoard()[x0 + 1][y0 - 1].getPiece() != null
                        && !board.getBoard()[x0 + 1][y0 - 1].getPiece()
                            .getColor().equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0 + 1, y0 - 1));
                }
            } else {

                if (board.getBoard()[x0 + 1][y0 - 1].getPiece() != null
                        && board.getBoard()[x0 + 1][y0 - 1].getPiece().getColor()
                            .equals(pieceColor)
                        && board.getBoard()[x0 + 1][y0 - 1].getPiece().getPieceType()
                            .equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (x0 + 1 < 8 && y0 + 1 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 + 1][y0 + 1].getPiece() == null
                        || (board.getBoard()[x0 + 1][y0 + 1].getPiece() != null
                        && !board.getBoard()[x0 + 1][y0 + 1].getPiece()
                            .getColor().equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0 + 1, y0 + 1));
                }
            } else {

                if (board.getBoard()[x0 + 1][y0 + 1].getPiece() != null
                        && board.getBoard()[x0 + 1][y0 + 1].getPiece()
                            .getColor().equals(pieceColor)
                        && board.getBoard()[x0 + 1][y0 + 1].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (x0 - 1 >= 0 && y0 - 1 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 - 1][y0 - 1].getPiece() == null
                        || (board.getBoard()[x0 - 1][y0 - 1].getPiece() != null
                        && !board.getBoard()[x0 - 1][y0 - 1].getPiece()
                            .getColor().equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0 - 1, y0 - 1));
                }
            } else {

                if (board.getBoard()[x0 - 1][y0 - 1].getPiece() != null
                        && board.getBoard()[x0 - 1][y0 - 1].getPiece()
                            .getColor().equals(pieceColor)
                        && board.getBoard()[x0 - 1][y0 - 1].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (x0 - 1 >= 0 && y0 + 1 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 - 1][y0 + 1].getPiece() == null
                        || (board.getBoard()[x0 - 1][y0 + 1].getPiece() != null
                        && !board.getBoard()[x0 - 1][y0 + 1].getPiece()
                            .getColor().equals(pieceColor))) {
                        moves.add(new AviableMove(x0, y0, x0 - 1, y0 + 1));
                }
            } else {

                if (board.getBoard()[x0 - 1][y0 + 1].getPiece() != null
                        && board.getBoard()[x0 - 1][y0 + 1].getPiece()
                            .getColor().equals(pieceColor)
                        && board.getBoard()[x0 - 1][y0 + 1].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        return false;
    }
}