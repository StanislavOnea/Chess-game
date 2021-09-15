package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Clasa folosita pentru a reprezenta piesa de sah - calul.
 */
public class Knight extends Piece {

    /**
     * @param color - culoarea piesei;
     * pieceType - tipul piesei - "knight";
     */
    public Knight(Color color) {
        super(color, PieceType.knight);
    }

    /**
     * Metoda folosita pentru a adauga in moves toate mutarile care
     * pot fi facute cu calul de culoarea cu care joaca botul sau pentru
     * a verifica daca calul adversarului ii poate da sah regelui.
     *
     * Cazul in care se verifa pentru calul de culoarea cu care joaca botul.
     * Se verifica pentru toate celule pe care poate fi mutat calul, daca
     * celula e goala sau se afla o piesa a adversarului,
     * care nu este rege, calul poate fi mutat acolo.
     *
     * Cazul in care se verifa pentru calul de culoarea adversarului.
     * Se verifa daca pe celula pe care poate fi deplasat se  afla regele
     * de culoarea cu care joaca botul, returneaza true.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves,
                                        Integer x0, Integer y0, Color turn) {
        boolean canMove = false;
        if (board.getBoard()[x0][y0].getPiece().getColor() == turn) {
            canMove = true;
        }
        if (x0 + 2 < 8 && y0 + 1 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 + 2][y0 + 1].getPiece() == null
                        || (!board.getBoard()[x0 + 2][y0 + 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 + 2][y0 + 1].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 + 2, y0 + 1));
                }
            } else {
                if (board.getBoard()[x0 + 2][y0 + 1].getPiece() != null
                        && board.getBoard()[x0 + 2][y0 + 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 + 2][y0 + 1].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }
            }
        }

        if (x0 + 2 < 8 && y0 - 1 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 + 2][y0 - 1].getPiece() == null
                        || (!board.getBoard()[x0 + 2][y0 - 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 + 2][y0 - 1].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 + 2, y0 - 1));
                }
            } else {
                if (board.getBoard()[x0 + 2][y0 - 1].getPiece() != null
                        && board.getBoard()[x0 + 2][y0 - 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 + 2][y0 - 1].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }

            }
        }

        if (x0 - 2 >= 0 && y0 + 1 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 - 2][y0 + 1].getPiece() == null
                        || (!board.getBoard()[x0 - 2][y0 + 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 - 2][y0 + 1].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 - 2, y0 + 1));
                }
            } else {
                if (board.getBoard()[x0 - 2][y0 + 1].getPiece() != null
                        && board.getBoard()[x0 - 2][y0 + 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 - 2][y0 + 1].getPiece()
                        .getColor().equals(turn)) {
                        return true;
                }
            }

        }

        if (x0 - 2 >= 0 && y0 - 1 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 - 2][y0 - 1].getPiece() == null
                        || (!board.getBoard()[x0 - 2][y0 - 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 - 2][y0 - 1].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 - 2, y0 - 1));
                }
            } else {
                if (board.getBoard()[x0 - 2][y0 - 1].getPiece() != null
                        && board.getBoard()[x0 - 2][y0 - 1].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 - 2][y0 - 1].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }
            }

        }

        if (x0 + 1 < 8 && y0 + 2 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 + 1][y0 + 2].getPiece() == null
                        || (!board.getBoard()[x0 + 1][y0 + 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 + 1][y0 + 2].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 + 1, y0 + 2));
                }
            } else {
                if (board.getBoard()[x0 + 1][y0 + 2].getPiece() != null
                        && board.getBoard()[x0 + 1][y0 + 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 + 1][y0 + 2].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }
            }

        }

        if (x0 + 1 < 8 && y0 - 2 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 + 1][y0 - 2].getPiece() == null
                        || (!board.getBoard()[x0 + 1][y0 - 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 + 1][y0 - 2].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 + 1, y0 - 2));
                }
            } else {
                if (board.getBoard()[x0 + 1][y0 - 2].getPiece() != null
                        && board.getBoard()[x0 + 1][y0 - 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 + 1][y0 - 2].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }
            }

        }

        if (x0 - 1 >= 0 && y0 + 2 < 8) {
            if (canMove) {
                if (board.getBoard()[x0 - 1][y0 + 2].getPiece() == null
                        || (!board.getBoard()[x0 - 1][y0 + 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 - 1][y0 + 2].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 - 1, y0 + 2));
                }
            } else {

                if (board.getBoard()[x0 - 1][y0 + 2].getPiece() != null
                        && board.getBoard()[x0 - 1][y0 + 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 - 1][y0 + 2].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }
            }

        }

        if (x0 - 1 >= 0 && y0 - 2 >= 0) {
            if (canMove) {
                if (board.getBoard()[x0 - 1][y0 - 2].getPiece() == null
                        || (!board.getBoard()[x0 - 1][y0 - 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && !board.getBoard()[x0 - 1][y0 - 2].getPiece()
                        .getColor().equals(turn))) {
                    moves.add(new AviableMove(x0, y0, x0 - 1, y0 - 2));
                }
            } else {
                if (board.getBoard()[x0 - 1][y0 - 2].getPiece() != null
                        && board.getBoard()[x0 - 1][y0 - 2].getPiece()
                        .getPieceType().equals(PieceType.king)
                        && board.getBoard()[x0 - 1][y0 - 2].getPiece()
                        .getColor().equals(turn)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Se verifica daca din pozitia curenta calul poate ajunge
     * pe cordonatele x, y.
     */
    public Boolean possibleMoves(Board board, Integer x0,
                                        Integer y0, Integer x1, Integer y1) {
        if (x0 + 2 < 8 && y0 + 1 < 8 && x0 + 2 == x1 && y0 + 1 == y1) {
            return true;

        }

        if (x0 + 2 < 8 && y0 - 1 >= 0 && x0 + 2 == x1 && y0 - 1 == y1) {
            return true;
        }

        if (x0 - 2 >= 0 && y0 + 1 < 8 && x0 - 2 == x1 && y0 + 1 == y1) {
            return true;
        }

        if (x0 - 2 >= 0 && y0 - 1 >= 0 && x0 - 2 == x1 && y0 - 1 == y1) {
            return true;
        }

        if (x0 + 1 < 8 && y0 + 2 < 8 && x0 + 1 == x1 && y0 + 2 == y1) {
            return true;
        }

        if (x0 + 1 < 8 && y0 - 2 >= 0 && x0 + 1 == x1 && y0 - 2 == y1) {
            return true;
        }

        if (x0 - 1 >= 0 && y0 + 2 < 8 && x0 - 1 == x1 && y0 + 2 == y1) {
            return true;

        }

        if (x0 - 1 < 8 && y0 - 2 >= 0 && x0 - 1 == x1 && y0 - 2 == y1) {
            return true;

        }

        return false;
    }

}
