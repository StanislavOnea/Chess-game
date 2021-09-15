package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Clasa folosita pentru a reprezenta piesa de sah - nebunul.
 */
public class Bishop extends Piece {

    /**
     * @param color - culoarea piesei;
     * pieceType - tipul piesei - "bishop";
     */
    public Bishop(Color color) {
        super(color, PieceType.bishop);
    }


    /**
     * Metoda pentru a realiza mutarile nebunului si a verifica daca un
     * nebun al adversarului ii da sah regelui.
     *
     * In aceasta metoda se adauga in vectorul moves toate mutarile care
     * pot fi realizate cu nebunul ce are culoarea cu care joaca botul
     * sau se verifica daca un nebun al adversarului ii poate da sah regelui
     * de culoarea cu care joaca botul, caz in care se returneaza true.
     *
     * Astfel variabila canMove e setata pe false cand se fac verificarile
     * pentru o piesa a adversarului si pe true cand se cauta misari pentru
     * o piesa cu care joaca botul.
     *
     * Se verifica pe toate diagonalele, celula cu celula, prin incrementarea
     * si decrementarea pozitiei curente pe care se afla piesa pana unde poate
     * fi deplasata. Daca canMove e true, se adauga in moves, daca
     * nu, se ignora.
     *
     * Atunci cand piesa e de culoarea cu care joaca botul si se intalneste
     * o alta piesa cu care joaca adversarul atunci aceasta e batuta, daca
     * e o piesa cuc are joaca botul, cautarea nu mai continua, piesa nu
     * poate fi deplasata in continuare.
     *
     * Atunci cand piesa e de culoarea adversarului si se intalneste o alta piesa
     * care nu e rege atunci cautarea se incheie, daca e regele de culoarea cu
     * carejoaca botul se returneaza true, inseamna ca regele e in sah.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves,
                                        Integer x0, Integer y0, Color turn) {
        boolean canMove = false;
        int i , j;
        if (board.getBoard()[x0][y0].getPiece().getColor().equals(turn)) {
            canMove = true;
        }

        i = x0 + 1;
        j = y0 + 1;
        while (i < 8 && j < 8) {
            if (canMove && board.getBoard()[i][j].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, i, j));
            }

            if (board.getBoard()[i][j].getPiece() != null
                    && !board.getBoard()[i][j].getPiece().getColor().equals(turn)
                    && !board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, i, j));
                }
                break;

            }

            if (board.getBoard()[i][j].getPiece() != null
                    && board.getBoard()[i][j].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[i][j].getPiece().getPieceType()
                                                            .equals(PieceType.king)) {
                    return true;
                }
                break;
            }

            i++;
            j++;

        }

        i = x0 - 1;
        j = y0 - 1;
        while (i >= 0 && j >= 0) {
            if (canMove && board.getBoard()[i][j].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, i, j));
            }

            if (board.getBoard()[i][j].getPiece() != null
                    && !board.getBoard()[i][j].getPiece().getColor().equals(turn)
                    && !board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, i, j));
                }
                break;

            }

            if (board.getBoard()[i][j].getPiece() != null
                    && board.getBoard()[i][j].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[i][j].getPiece().getPieceType()
                                                                    .equals(PieceType.king)) {
                    return true;
                }
                break;
            }
            i--;
            j--;
        }

        i = x0 - 1;
        j = y0 + 1;
        while (j < 8 && i >= 0) {
            if (canMove && board.getBoard()[i][j].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, i, j));
            }

            if (board.getBoard()[i][j].getPiece() != null
                    && !board.getBoard()[i][j].getPiece().getColor().equals(turn)
                    && !board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, i, j));
                }
                break;

            }

            if (board.getBoard()[i][j].getPiece() != null
                    && board.getBoard()[i][j].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[i][j].getPiece().getPieceType()
                                                                        .equals(PieceType.king)) {
                    return true;
                }
                break;
            }

            i--;
            j++;
        }

        i = x0 + 1;
        j = y0 - 1;
        while (j >= 0 && i < 8) {
            if (canMove && board.getBoard()[i][j].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, i, j));
            }

            if (board.getBoard()[i][j].getPiece() != null
                    && !board.getBoard()[i][j].getPiece().getColor().equals(turn)
                    && !board.getBoard()[i][j].getPiece().getPieceType().equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, i, j));
                }
                break;

            }

            if (board.getBoard()[i][j].getPiece() != null
                    && board.getBoard()[i][j].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[i][j].getPiece().getPieceType()
                                                            .equals(PieceType.king)) {
                    return true;
                }
                break;
            }
            i++;
            j--;

        }
        return false;
    }

    /**
     *
     * Metoda folosita pentru a verifica daca o piesa poate ajunge pe pozitiile x1 si y1.
     *
     * Acesta metoda este folosita pentru a verifa daca regele va fi mutat pe coordonatele
     * x1 si y1 poate fi batut de vrio piesa a adversarului.
     *
     * Se incrementeaza apoi se decrementeaza linia si coloana pe care se afla
     * initial piesa (x0 si y0), pana ajung sa aiba valoarea x1 si y1. Daca se
     * intalneste o piesa in cale fara sa se ajunga la destinatie, se returneaza false,
     * pentru ca piesa nu poate ajunge la pozitia finala.
     *
     * Altfel se returneaza true.
     */
    public Boolean possibleMoves(Board board, Integer x0, Integer y0, Integer x1, Integer y1) {
        Color pieceColor;
        int i , j = 0;

        pieceColor = board.getBoard()[x0][y0].getPiece().getColor();

        i = x0 + 1;
        j = y0 + 1;
        while (i < 8 && j < 8) {
            if (i == x1 && j == y1) {
                return true;
            }

            if (board.getBoard()[i][j].getPiece() != null) {
                break;
            }

            i++;
            j++;

        }

        i = x0 - 1;
        j = y0 - 1;
        while (i >= 0 && j >= 0) {
            if (i == x1 && j == y1) {
                return true;
            }

            if (board.getBoard()[i][j].getPiece() != null) {
                break;
            }

            i--;
            j--;

        }

        i = x0 - 1;
        j = y0 + 1;
        while (i >= 0 && j < 8) {
            if (i == x1 && j == y1) {
                return true;
            }

            if (board.getBoard()[i][j].getPiece() != null) {
                break;
            }

            i--;
            j++;

        }

        i = x0 + 1;
        j = y0 - 1;
        while (i < 8 && j >= 0) {
            if (i == x1 && j == y1) {
                return true;
            }

            if (board.getBoard()[i][j].getPiece() != null) {
                break;
            }

            i++;
            j--;

        }

        return false;
    }
}
