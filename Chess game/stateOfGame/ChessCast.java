package stateOfGame;

import board.Board;
import pieces.Color;
import pieces.PieceType;

import java.util.ArrayList;

public class ChessCast {
    private Boolean greatCast;
    private Boolean smallCast;

    public Boolean getGreatCast() {
        return greatCast;
    }

    public void setGreatCast(Boolean greatCast) {
        this.greatCast = greatCast;
    }

    public Boolean getSmallCast() {
        return smallCast;
    }

    public void setSmallCast(Boolean smallCast) {
        this.smallCast = smallCast;
    }

    public void checkCastConditions(Integer x0, Integer y0, Color turn) {
        if (turn.equals(Color.white) && x0 == 0 && y0 == 7) {
            smallCast = false;
        }

        if (turn.equals(Color.white) && x0 == 0 && y0 == 0) {
            greatCast = false;
        }

        if (turn.equals(Color.white) && x0 == 0 && y0 == 4) {
            smallCast = false;
            greatCast = false;
        }

        if (turn.equals(Color.black) && x0 == 7 && y0 == 7) {
            smallCast = false;
        }

        if (turn.equals(Color.black) && x0 == 7 && y0 == 0) {
            greatCast = false;
        }

        if (turn.equals(Color.black) && x0 == 7 && y0 == 4) {
            smallCast = false;
            greatCast = false;
        }

    }

    public void checkChessCast(Board board, Integer x0, Integer y0, Integer x1, Integer y1) {
        if (board.getBoard()[x1][y1].getPiece() == null) {
            return;
        }

        if (board.getBoard()[x1][y1].getPiece() != null
                && !board.getBoard()[x1][y1].getPiece().getPieceType().equals(PieceType.king)) {
            return;
        }

        if (y0 == 4 && y1 == 6) {
            board.movePiece(x0, 7, x0, 5);
        }

        if (y0 == 4 && y1 == 2) {
            board.movePiece(x0, 0, x0, 3);
        }
    }

    public Boolean checkSmallCast(StateOfGame stateOfGame) {
        int x0 = 0, y0 = 0;
        Board board = stateOfGame.getBoard();

        if (!smallCast) {
            return false;
        }

        if (stateOfGame.verifyChess()) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    if (board.getBoard()[i][j].getPiece().getColor().equals(stateOfGame.getTurn())
                            && board.getBoard()[i][j].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                        x0 = i;
                        y0 = j;
                    }
                }
            }
        }

        if (y0 + 2 < 8) {
            if (board.getBoard()[x0][y0 + 1].getPiece() != null
                    || board.getBoard()[x0][y0 + 2].getPiece() != null) {
                return false;
            }

            board.movePiece(x0, y0, x0, y0 + 1);
            boolean chess = stateOfGame.verifyChess();
            board.movePiece(x0, y0 + 1, x0, y0);
            if (chess) {
                return false;
            }


            board.movePiece(x0, y0, x0, y0 + 2);
            board.movePiece(x0, 7, x0, 5);
            if (stateOfGame.verifyChess()) {
                board.movePiece(x0, y0 + 2, x0, y0);
                board.movePiece(x0, 5, x0, 7);
                return false;
            } else {
                stateOfGame.setAviableMoves(new ArrayList<>());
                stateOfGame.getAviableMoves().add(new AviableMove(x0, y0, x0, y0 + 2));
                smallCast = false;
                greatCast = false;
                return true;
            }

        }

        return false;
    }

    public Boolean checkGreatCast(StateOfGame stateOfGame) {
        int x0 = 0, y0 = 0;
        Board board = stateOfGame.getBoard();
        if (!greatCast) {
            return false;
        }

        if (stateOfGame.verifyChess()) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoard()[i][j].getPiece() != null) {
                    if (board.getBoard()[i][j].getPiece().getColor().equals(stateOfGame.getTurn())
                            && board.getBoard()[i][j].getPiece()
                            .getPieceType().equals(PieceType.king)) {
                        x0 = i;
                        y0 = j;
                    }
                }
            }
        }

        if (y0 - 3 > 0) {
            if (board.getBoard()[x0][y0 - 1].getPiece() != null
                    || board.getBoard()[x0][y0 - 2].getPiece() != null
                    || board.getBoard()[x0][y0 - 3].getPiece() != null) {
                return false;
            }

            board.movePiece(x0, y0, x0, y0 - 1);
            boolean chess = stateOfGame.verifyChess();
            board.movePiece(x0, y0 - 1, x0, y0);
            if (chess) {
                return false;
            }

            board.movePiece(x0, y0, x0, y0 - 2);
            board.movePiece(x0, 0, x0, 3);
            if (stateOfGame.verifyChess()) {
                board.movePiece(x0, y0 - 2, x0, y0);
                board.movePiece(x0, 3, x0, 0);
                return false;
            } else {
                stateOfGame.setAviableMoves(new ArrayList<>());
                stateOfGame.getAviableMoves().add(new AviableMove(x0, y0, x0, y0 - 2));
                smallCast = false;
                greatCast = false;
                return true;
            }
        }
        return false;
    }
}
