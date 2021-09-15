package pieces;

import board.Board;
import stateOfGame.AviableMove;

import java.util.ArrayList;

/**
 * Aceasta clasa este folosita pentru reprezentarea interna a pieselor
 * de joc. Este clasa parinte din care sunt extinse clase pentru toate
 * tipurile pieselor de sah.
 */
public class Piece {
    private Color color;
    private PieceType pieceType;

    /**
     *
     * @param color - culoarea piesei;
     * @param pieceType - tipul piesei;
     */
    public Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    /**
     * Getteri si setteri pentru a seta/returna culoarea, tipul
     * si starea piesei de joc.
     */
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * Metode pentru a realiza mutarea piesei.
     */
    public Boolean move(Board board, ArrayList<AviableMove> moves, Integer x0, Integer y0, Color pieceColor){
        return false;
    }

    /**
     * Metoda folosita pentru a verifica daca o piesa poate ajunge pe pozitie x1, y1.
     */
    public Boolean possibleMoves(Board board, Integer x0, Integer y0, Integer x1, Integer y1) {
        return false;
    }


}