package board;

import pieces.Piece;

/**
 * Aceasta clasa reprezinta o casuta/celula de pe tabla de sah, care poate contine
 * o piesa sau null - aceasta insemnand ca casuta e libera.
 * De asemenea se salveaza in line si column pozitia acestei piese pe tabla
 * de sah.
 */
public class Cell {
    private Piece piece;
    private Integer line, column;

    /**
     *
     * @param piece - piesa setata in aceasta casuta;
     * @param x - linia pe care se afla;
     * @param y - coloana pe care se afla;
     */
    public Cell(Piece piece, int x, int y) {
        this.piece = piece;
        this.line = x;
        this.column = y;
    }

    /**
     * Getteri si setteri pentru piesa, pozitia ei pe linie/coloana.
     */
    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return line;
    }

    public void setX(Integer x) {
        this.line = x;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
}

