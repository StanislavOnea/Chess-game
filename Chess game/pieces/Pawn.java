package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Clasa folosita pentru a reprezenta piesa de sah - pionul.
 * Contine un camp firstMove - daca e setat pe true, exita posibilitatea
 * de a realiza prima mutare cu doua pozitii inainte, dupa prima
 * mutare a pionului se seteaza pe false.
 */

public class Pawn extends Piece {

    private boolean firstMove = true;

    /**
     * @param color - culoarea piesei;
     *              pieceType - tipul piesei - "pawn";
     */
    public Pawn(Color color) {
        super(color, PieceType.pawn);
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    /**
     * Metoda folosita pentru a adauga in moves toate mutarile care
     * pot fi facute cu pionul de culoarea cu care joaca botul sau pentru
     * a verifica daca pionul adversarului ii poate da sah regelui.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves,
                        Integer x0, Integer y0, Color pieceColor) {

        int turn;
        Color color;
        boolean remove = false, canRemove = false;

        if (board.getBoard()[x0][y0].getPiece().getColor().equals(Color.white)) {
            turn = 1;
            color = Color.white;
        } else {
            turn = -1;
            color = Color.black;
        }

        if (board.getBoard()[x0][y0].getPiece().getColor().equals(pieceColor)) {
            canRemove = true;
        }

        if (y0 == 7 && x0 + turn >= 0 && x0 + turn < 8) {
            if (canRemove) {
                if (board.getBoard()[x0 + turn][y0 - 1].getPiece() != null
                        && !board.getBoard()[x0 + turn][y0 - 1].getPiece()
                        .getColor().equals(color)
                        && !board.getBoard()[x0 + turn][y0 - 1].getPiece()
                        .getPieceType().equals(PieceType.king)) {
                    remove = true;
                    moves.add(new AviableMove(x0, y0, x0 + turn, y0 - 1));
                }
            } else {

                if (board.getBoard()[x0 + turn][y0 - 1].getPiece() != null
                        && board.getBoard()[x0 + turn][y0 - 1].getPiece()
                        .getColor().equals(pieceColor)
                        && board.getBoard()[x0 + turn][y0 - 1].getPiece()
                        .getPieceType().equals(PieceType.king)) {

                    return true;
                }
            }
        }

        if (y0 == 0 && x0 + turn >= 0 && x0 + turn < 8) {
            if (canRemove) {
                if (board.getBoard()[x0 + turn][y0 + 1].getPiece() != null
                        && !board.getBoard()[x0 + turn][y0 + 1]
                        .getPiece().getColor().equals(color)
                        && !board.getBoard()[x0 + turn][y0 + 1]
                        .getPiece().getPieceType().equals(PieceType.king)) {
                    remove = true;
                    moves.add(new AviableMove(x0, y0, x0 + turn, y0 + 1));
                }
            } else {

                if (board.getBoard()[x0 + turn][y0 + 1].getPiece() != null
                        && board.getBoard()[x0 + turn][y0 + 1]
                        .getPiece().getColor().equals(pieceColor)
                        && board.getBoard()[x0 + turn][y0 + 1]
                        .getPiece().getPieceType().equals(PieceType.king)) {
                    return true;
                }
            }
        }

        if (y0 < 8 && y0 >= 0) {
            if (x0 + turn >= 0 && x0 + turn < 8 && y0 - 1 >= 0) {
                if (canRemove) {
                    if (board.getBoard()[x0 + turn][y0 - 1].getPiece() != null
                            && !board.getBoard()[x0 + turn][y0 - 1]
                            .getPiece().getColor().equals(color)
                            && !board.getBoard()[x0 + turn][y0 - 1]
                            .getPiece().getPieceType().equals(PieceType.king)) {
                        remove = true;
                        moves.add(new AviableMove(x0, y0, x0 + turn, y0 - 1));

                    }
                } else {
                    if (board.getBoard()[x0 + turn][y0 - 1].getPiece() != null
                            && board.getBoard()[x0 + turn][y0 - 1]
                            .getPiece().getColor().equals(pieceColor)
                            && board.getBoard()[x0 + turn][y0 - 1]
                            .getPiece().getPieceType().equals(PieceType.king)) {
                        return true;
                    }
                }
            }
            if (x0 + turn >= 0 && x0 + turn < 8 && y0 + 1 < 8) {
                if (canRemove) {
                    if (board.getBoard()[x0 + turn][y0 + 1].getPiece() != null
                            && !board.getBoard()[x0 + turn][y0 + 1]
                            .getPiece().getColor().equals(color)
                            && !board.getBoard()[x0 + turn][y0 + 1]
                            .getPiece().getPieceType().equals(PieceType.king)) {
                        remove = true;
                        moves.add(new AviableMove(x0, y0, x0 + turn, y0 + 1));
                    }
                } else {
                    if (board.getBoard()[x0 + turn][y0 + 1].getPiece() != null
                            && board.getBoard()[x0 + turn][y0 + 1]
                            .getPiece().getColor().equals(pieceColor)
                            && board.getBoard()[x0 + turn][y0 + 1]
                            .getPiece().getPieceType().equals(PieceType.king)) {
                        return true;
                    }
                }
            }

        }

        if (x0 == 1 && color.equals(Color.white) && !remove && canRemove) {
            if (board.getBoard()[x0 + turn][y0].getPiece() == null
                    && board.getBoard()[x0 + 2 * turn][y0].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, x0 + 2 * turn, y0));
            }
        }

        if (x0 == 6 && color.equals(Color.black) && !remove && canRemove) {
            if (board.getBoard()[x0 + turn][y0].getPiece() == null
                    && board.getBoard()[x0 + 2 * turn][y0].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, x0 + 2 * turn, y0));
            }
        }

        if (x0 + turn >= 0 && x0 + turn < 8 && !remove && canRemove) {
            if (board.getBoard()[x0 + turn][y0].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, x0 + turn, y0));
            }
        }

        return false;
    }

    /**
     * Returneaza true caz in care pionul poate sa bata
     * piesa de pe coordonatele x1, y1.
     */
    public Boolean possibleMoves(Board board, Integer x0,
                                 Integer y0, Integer x1, Integer y1) {
        int turn = -1;
        if (board.getBoard()[x0][y0].getPiece().getColor() == Color.white) {
            turn = 1;
        }

        if (y0 == 7 && x0 + turn >= 0 && x0 + turn < 8) {
            if (x0 + turn >= 0 && x0 < 8 && x0 + turn == x1 && y0 - 1 == y1) {

                return true;
            }
        }

        if (y0 == 0 && x0 + turn >= 0 && x0 + turn < 8) {
            if (x0 + turn >= 0 && x0 + turn < 8 && x0 + turn == x1 && y0 + 1 == y1) {
                return true;
            }
        }

        if (x0 + turn >= 0 && x0 + turn < 8 && x0 + turn == x1 && y0 - 1 == y1) {
            return true;

        }

        if (x0 + turn >= 0 && x0 + turn < 8 && x0 + turn == x1 && y0 + 1 == y1) {
            return true;
        }

        return false;
    }
}
