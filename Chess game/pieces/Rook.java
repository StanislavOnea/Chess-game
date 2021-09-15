package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Clasa folosita pentru a reprezenta piesa de sah - turnul.
 */
public class Rook extends Piece {
    /**
     * @param color - culoarea piesei;
     *              pieceType - tipul piesei - "rook";
     */
    public Rook(Color color) {
        super(color, PieceType.rook);
    }

    /**
     * Aceasta metoda este folosita pentru a gasi toate miscarile care pot
     * fi realizate cu turnul cu care joaca botul sau daca turnul adversar
     * ia dat sah regelui de culoarea cu care joaca botul.
     *
     * Prima data se verifca daca este o piesa cu care joaca botul, atunci
     * poate fi mutata canMove e true, altfel e false.
     *
     * Se pleaca de la coordonatele initiale ale turnului linia find x0 si coloana
     * y0.
     *
     * Se incrementeaza x0 pana se ajunge pe ultima linie a tablei de sah.
     * Astfel se verifica  pentru celula adiacenta, apoi urmatoarea celula,
     * pana la x0 == 7.
     *
     * Cand se fac verificarile pentru turnul cu care joaca botul, daca celula e
     * goala, inseamna ca turnul poate fi mutat pe celula respectiva, mutarea se
     * adauga in moves.
     *
     * Daca se fac verificarile pentru turnul adversarului celulele nule se ignora.
     *
     * Cand intalnim o piesa, avem siguranta ca pana am ajuns acolo toate celule au fost
     * goale, astfel daca piesa e a adversarului se bate, adaugam miscarea in moves,
     * altfel, verifiarile inceteaza, x0 nu se mai incrementeaza, se incep  cautarile
     * decrementand x0.
     *
     * Daca faceam verificari pentru o piesa a adversarului, ne uitam piesa la care poate
     * ajunge e regele de culaorea cu care joaca botul, atunci ii poate da sah
     * si returnam true.
     *
     * Procedam astfel decrementand x0, apoi incrementat y0 si decrementam.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves,
                        Integer x0, Integer y0, Color turn) {

        boolean canMove = false;
        int i;
        if (board.getBoard()[x0][y0].getPiece().getColor().equals(turn)) {
            canMove = true;
        }

        i = x0 + 1;
        while (i < 8) {
            if (canMove && board.getBoard()[i][y0].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, i, y0));
            }

            if (board.getBoard()[i][y0].getPiece() != null
                    && !board.getBoard()[i][y0].getPiece().getColor().equals(turn)
                    && !board.getBoard()[i][y0].getPiece().getPieceType()
                        .equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, i, y0));
                }
                break;

            }

            if (board.getBoard()[i][y0].getPiece() != null
                    && board.getBoard()[i][y0].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[i][y0].getPiece().getPieceType()
                        .equals(PieceType.king)) {
                    return true;
                }
                break;
            }

            i++;

        }

        i = x0 - 1;
        while (i >= 0) {
            if (canMove && board.getBoard()[i][y0].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, i, y0));
            }

            if (board.getBoard()[i][y0].getPiece() != null
                    && !board.getBoard()[i][y0].getPiece().getColor().equals(turn)
                    && !board.getBoard()[i][y0].getPiece().getPieceType()
                        .equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, i, y0));
                }
                break;
            }

            if (board.getBoard()[i][y0].getPiece() != null
                    && board.getBoard()[i][y0].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[i][y0].getPiece().getPieceType()
                            .equals(PieceType.king)) {
                    return true;
                }

                break;

            }
            i--;
        }

        i = y0 + 1;
        while (i < 8) {
            if (canMove && board.getBoard()[x0][i].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, x0, i));
            }


            if (board.getBoard()[x0][i].getPiece() != null
                    && !board.getBoard()[x0][i].getPiece().getColor().equals(turn)
                    && !board.getBoard()[x0][i].getPiece().getPieceType()
                        .equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, x0, i));
                }
                break;
            }


            if (board.getBoard()[x0][i].getPiece() != null
                    && board.getBoard()[x0][i].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[x0][i].getPiece().getPieceType()
                            .equals(PieceType.king)) {
                    return true;
                }
                break;
            }

            i++;
        }

        i = y0 - 1;
        while (i >= 0) {
            if (canMove && board.getBoard()[x0][i].getPiece() == null) {
                moves.add(new AviableMove(x0, y0, x0, i));
            }


            if (board.getBoard()[x0][i].getPiece() != null
                    && !board.getBoard()[x0][i].getPiece().getColor().equals(turn)
                    && !board.getBoard()[x0][i].getPiece().getPieceType()
                        .equals(PieceType.king)) {
                if (canMove) {
                    moves.add(new AviableMove(x0, y0, x0, i));
                }
                break;
            }

            if (board.getBoard()[x0][i].getPiece() != null
                    && board.getBoard()[x0][i].getPiece().getColor().equals(turn)) {
                if (!canMove && board.getBoard()[x0][i].getPiece().getPieceType()
                        .equals(PieceType.king)) {
                    return true;
                }
                break;

            }
            i--;

        }
        return false;
    }

    /**
     * Metoda folosita pentru a verifica daca o piesa poate ajunge pe pozitiile
     * x1 si y1.
     *
     * Acesta metoda este folosita pentru a verifa daca regele va fi mutat
     * pe coordonatele x1 si y1, poate fi batut de vrio piesa a adversarului.
     *
     * Se incrementeaza apoi se decrementeaza linia si coloana pe care se afla
     * initial piesa (x0 si y0), pana ajung sa aiba valoarea x1 si y1. Daca se
     * intalneste o piesa in cale fara sa se ajunga la destinatie, se returneaza false,
     * pentru ca piesa nu poate ajunge la pozitia finala.
     *
     *
     * Altfel se returneaza true.
     */
    public Boolean possibleMoves(Board board, Integer x0, Integer y0, Integer x1, Integer y1) {
        Color pieceColor;
        int i = 0;

        pieceColor = board.getBoard()[x0][y0].getPiece().getColor();

        i = x0 + 1;
        while (i < 8) {
            if (i == x1 && y0 == y1) {
                return true;
            }

            if (board.getBoard()[i][y0].getPiece() != null) {
                break;
            }

            i++;

        }

        i = x0 - 1;
        while (i >= 0) {
            if (i == x1 && y0 == y1) {
                return true;
            }

            if (board.getBoard()[i][y0].getPiece() != null) {
                break;
            }

            i--;
        }

        i = y0 + 1;
        while (i < 8) {
            if (x0 == x1 && i == y1) {
                return true;
            }

            if (board.getBoard()[x0][i].getPiece() != null) {
                break;
            }

            i++;
        }

        i = y0 - 1;
        while (i >= 0) {
            if (x0 == x1 && i == y1) {
                return true;
            }

            if (board.getBoard()[x0][i].getPiece() != null) {
                break;
            }

            i--;

        }
        return false;
    }

}