package stateOfGame;

import board.Board;
import pieces.*;
import writeStateOfGame.WriteOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Aceasta clasa este folosita pentru a realiza actiunile necesare pe
 * parcursul evolutiei jocului - mutarile pieselor de sah si in starea
 * force de realizarea tuturor modifiarilor primite.
 */
public class StateOfGame {
    private Color turn;
    private Board board;
    private ArrayList<AviableMove> aviableMoves;
    private EnPassant enPassant;
    private Move printMove;
    private ChessCast chessCast;

    public StateOfGame() {
        this.aviableMoves = new ArrayList<>();
        this.enPassant = new EnPassant();
        this.printMove = new Move();
        this.chessCast = new ChessCast();
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<AviableMove> getAviableMoves() {
        return aviableMoves;
    }

    public Color getTurn() {
        return turn;
    }

    public void setAviableMoves(ArrayList<AviableMove> aviableMoves) {
        this.aviableMoves = aviableMoves;
    }

    public ChessCast getChessCast() {
        return chessCast;
    }

    public void setTurn(Color turn) {
        this.turn = turn;
    }

    public EnPassant getEnPassant() {
        return enPassant;
    }

    /**
     * Se intializeaza o tabla de joc.
     * Se seteaza greatCast si smallCast pe true, aceasta insemnand ca
     * se poate efectua rocada mica sau mare cu prima ocazie.
     */
    public void initBoard() {
        this.board = new Board();
        this.turn = Color.white;
        this.chessCast.setGreatCast(true);
        this.chessCast.setSmallCast(true);
    }

    /**
     * Se verifica daca un pion a promovat la regina.
     */
    public Boolean checkPromote (Integer x0, Integer y0, WriteOutput writeOutput) throws IOException {
        if (x0 == 7 && board.getBoard()[x0][y0].getPiece() != null
                && board.getBoard()[x0][y0].getPiece()
                .getPieceType().equals(PieceType.pawn)
                && board.getBoard()[x0][y0].getPiece()
                .getColor().equals(Color.white)) {

            board.getBoard()[x0][y0].setPiece(new Queen(Color.white));
            return true;
        }

        if (x0 == 0 && board.getBoard()[x0][y0].getPiece() != null
                && board.getBoard()[x0][y0].getPiece()
                .getPieceType().equals(PieceType.pawn)
                && board.getBoard()[x0][y0].getPiece().
                getColor().equals(Color.black)) {

            board.getBoard()[x0][y0].setPiece(new Queen(Color.black));
            return true;
        }

        return false;

    }

    /**
     * Se selecteaza o miscare din toate cele posibile din moves.
     */
    public Integer[] selectMove () {
        int i = 0;
        Integer[] move = new Integer[4];
        Random random = new Random();

        if (aviableMoves.size() == 0) {
            System.out.println("resign");
            return null;
        }

        if (aviableMoves.size() == 1) {
            move[0] = aviableMoves.get(i).getX0();
            move[1] = aviableMoves.get(i).getY0();
            move[2] = aviableMoves.get(i).getX1();
            move[3] = aviableMoves.get(i).getY1();
        }

        if (aviableMoves.size() > 1) {
            i = random.nextInt(aviableMoves.size());
            move[0] = aviableMoves.get(i).getX0();
            move[1] = aviableMoves.get(i).getY0();
            move[2] = aviableMoves.get(i).getX1();
            move[3] = aviableMoves.get(i).getY1();
        }
        return move;
    }

    /**
     * Se muta o piesa cu care joaca botul.
     */
    public void engineMove(WriteOutput writeOutput) throws IOException {
        Integer[] move;
        boolean doMove = false;
        Integer x0 = 0, y0 = 0, x1 = 0, y1 = 0;
        findAviableMoves();

        move = selectMove();
        if (move != null) {
            if (!chessCast.checkGreatCast(this) && !chessCast.checkSmallCast(this)) {
                x0 = move[0];
                y0 = move[1];
                x1 = move[2];
                y1 = move[3];
                Piece oldPiece = board.getBoard()[x1][y1].getPiece();
                board.movePiece(x0, y0, x1, y1);
                if (verifyChess()) {
                    board.getBoard()[x0][y0].setPiece(board.getBoard()[x1][y1].getPiece());
                    board.getBoard()[x1][y1].setPiece(oldPiece);
                } else {
                    doMove = true;
                }

                if (!doMove) {
                    for (int i = 0; i < aviableMoves.size(); i++) {
                        x0 = aviableMoves.get(i).getX0();
                        y0 = aviableMoves.get(i).getY0();
                        x1 = aviableMoves.get(i).getX1();
                        y1 = aviableMoves.get(i).getY1();
                        oldPiece = board.getBoard()[x1][y1].getPiece();
                        board.movePiece(x0, y0, x1, y1);
                        if (verifyChess()) {
                            board.getBoard()[x0][y0].setPiece(board.getBoard()[x1][y1].getPiece());
                            board.getBoard()[x1][y1].setPiece(oldPiece);
                        } else {
                            doMove = true;
                            break;
                        }
                    }
                }
            } else {
                x0 = aviableMoves.get(0).getX0();
                y0 = aviableMoves.get(0).getY0();
                x1 = aviableMoves.get(0).getX1();
                y1 = aviableMoves.get(0).getY1();
                doMove = true;
            }
        }


        if (doMove) {
            chessCast.checkCastConditions(x0, y0, turn);
            enPassant.checkEnPassant(board, x1, y1, turn);
            if (checkPromote(x1, y1, writeOutput)) {
                printMove.printMove(x0, y0, x1, y1, 'q');

            } else {
                printMove.printMove(x0, y0, x1, y1, '0');
            }

            if (turn.equals(Color.white)) {
                turn = Color.black;
            } else {
                turn = Color.white;
            }
        } else {
            System.out.println("resign");
        }

        writeOutput.writeBoard(board);

    }

    public Boolean verifyChess() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].getPiece() != null
                        && !board.getBoard()[i][j].getPiece().getColor().equals(turn)) {
                    if (board.getBoard()[i][j].getPiece()
                            .move(board, aviableMoves, i, j, turn)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Se adauga in moves toate miscarile care pot fi realizate de bot
     * si se verifca daca regele a primit sah. Daca da, se apeleaza
     * metodele care cauta cum sa scoata regele din sah.
     */
    public void findAviableMoves() {
        aviableMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    board.getBoard()[i][j].getPiece().move(board, aviableMoves, i, j, turn);
                }
            }
        }
    }

}