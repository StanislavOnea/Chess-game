package stateOfGame;

import board.Board;
import pieces.Color;
import pieces.PieceType;

/**
 * Aceasta clasa este utilizata pentru a verifica daca se paote face
 * en passant.
 * In membrii ei, x0 si y0 se retine pozitia ultimei piese mutate.
 */
public class EnPassant {
    private Integer x0;
    private Integer y0;

    public EnPassant() {
        this.x0 = 0;
        this.y0 = 0;
    }

    public void setX0(Integer x0) {
        this.x0 = x0;
    }

    public void setY0(Integer y0) {
        this.y0 = y0;
    }

    /**
     * Acesta metoda este folosita pentru a se verifica daca se paote face en passant.
     *
     * Prima data se verifica daca ultima piesa mutata, nu este un pion al adversatului,
     * atunci en passant-ul nu poate fi realizat.
     *
     * Apoi se verifica daca pionul adversarului a inaintat cu doua pozitii.
     * Adica pionul alb trebuie sa fie pe linia 3 pe tabla de sah, iar cel negru pe linia
     * 4 pe tabla interna de sah.
     *
     * Daca conditiile de mai sus sunt respectate, atunci se verifica daca
     * in partea dreapta, apoi in partea stanga este un pion de cularea
     * care e la mutare.
     *
     * Apoi se verifica daca pionul poate fi mutat, cu o linie mai sus pe coloana
     * pe care se afla pionul care doreste sa fie batut. Se verifca ca pozitia
     * in care trebuie sa fie mutat pionul jucatorului sa nu contina o alta piesa,
     * dar daca o contine sa nu fie rege si de culoarea cu care joaca adversarul.
     *
     * Daca toate aceste conditii sunt respecate, atunci se poate realiza en passant
     * si acesta mutare se adauga in vectorul de posibile mutari.
     * @param stateOfGame
     */
    public void enPassant(StateOfGame stateOfGame) {
        Board board = stateOfGame.getBoard();
        int count = 1;
        if (stateOfGame.getTurn() == Color.black) {
            count = -1;
        }

        if (!board.getBoard()[x0][y0].getPiece().getPieceType().equals(PieceType.pawn)) {
            return;
        }

        if (board.getBoard()[x0][y0].getPiece().getColor().equals(stateOfGame.getTurn())) {
            return;
        }

        if ((board.getBoard()[x0][y0].getPiece().getColor().equals(Color.white) && x0 != 3)
                || (board.getBoard()[x0][y0].getPiece().getColor().equals(Color.black)
                    && x0 != 4)) {
            return;
        }

        if (y0 + 1 < 8) {
            if (board.getBoard()[x0][y0 + 1].getPiece() != null
                && board.getBoard()[x0][y0 + 1].getPiece().getPieceType().equals(PieceType.pawn)
                && board.getBoard()[x0][y0 + 1].getPiece().getColor().equals(stateOfGame.getTurn())
                && (board.getBoard()[x0 + count][y0].getPiece() == null
                || board.getBoard()[x0 + count][y0].getPiece() != null
                && !board.getBoard()[x0 + count][y0].getPiece().getPieceType()
                    .equals(PieceType.king)
                && !board.getBoard()[x0 + count][y0].getPiece().getColor()
                    .equals(stateOfGame.getTurn()))) {
                stateOfGame.getAviableMoves().add(
                        new AviableMove(x0, y0 + 1, x0 + count, y0));
            }
        }

        if (y0 - 1 >= 0) {
            if (board.getBoard()[x0][y0 - 1].getPiece() != null
                && board.getBoard()[x0][y0 - 1].getPiece().getPieceType().equals(PieceType.pawn)
                && board.getBoard()[x0][y0 - 1].getPiece().getColor().equals(stateOfGame.getTurn())
                && (board.getBoard()[x0 + count][y0].getPiece() == null
                || board.getBoard()[x0 + count][y0].getPiece() != null
                && !board.getBoard()[x0 + count][y0].getPiece().getPieceType()
                    .equals(PieceType.king)
                && !board.getBoard()[x0 + count][y0].getPiece().getColor()
                    .equals(stateOfGame.getTurn()))) {
                stateOfGame.getAviableMoves().add(
                        new AviableMove(x0, y0 - 1, x0 + count, y0));
            }
        }

    }

    /**
     * Aceasta metoda este folosita pentru a verifica daca sa facut en passant.
     *
     * Se verifica daca ultima piesa mutata in pozitia x1, y1 este
     * un pion al jucatorului curent si ultima piesa mutata de adversarul lui
     * cu coordonatele x0 si y0 a fost la fel un pion. Daca piesa a fost mutata
     * cu o linie mai sus fata de piesa adversarului pe aceiasi coloana, inseamna
     * ca sa facut en passant si piesa adversarului este batuta.
     */
    public void checkEnPassant(Board board, Integer x1, Integer y1, Color turn) {
        int count = -1;
        if (turn == Color.black) {
            count = 1;
        }


        if (board.getBoard()[x1][y1].getPiece() != null
            && board.getBoard()[x1][y1].getPiece().getPieceType().equals(PieceType.pawn)
                && board.getBoard()[x1][y1].getPiece().getColor().equals(turn)) {

            if (x1 + count >= 0 && x1 + count < 8) {
                if (board.getBoard()[x0][y0].getPiece() != null
                    && board.getBoard()[x0][y0].getPiece().getPieceType().equals(PieceType.pawn)
                        && !board.getBoard()[x0][y0].getPiece().getColor().equals(turn)) {
                    if (x1 + count == x0 && y1 == y0) {
                        board.getBoard()[x0][y0].setPiece(null);
                    }
                }
            }
        }
    }
}
