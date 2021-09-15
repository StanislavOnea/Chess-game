package board;
import pieces.*;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Aceasta clasa este folosita pentru reprezentarea interna a tablei de sah.
 * Contine un membu Cell care reprezinta tabla de sah sub forma unei matrice
 * 8x8. Pe fiecare pozitie din matrice poate fi o piesa de sah, casutele goale
 * sunt initializate cu null.
 */
public class Board {
    private Cell[][] board;
    private final Integer size;

    /**
     *  Se initializeaza tabla de sah de dimensiune 8x8.
     */
    public Board() {
        this.size = 8;
        this.board = new Cell[size][size];
        createBoard();
    }

    public Cell[][] getBoard() {
        return board;
    }

    /**
     * Se amplaseaza pe tabla piesele de joc albe si negre in pozitiile
     * corespunzatoare de la ineputul jocului, casutele goale sunt initializate
     * cu null.
     */
    public void createBoard() {

        board[0][0] = new Cell(new Rook(Color.white), 0, 0);
        board[0][1] = new Cell(new Knight(Color.white), 0, 1);
        board[0][2] = new Cell(new Bishop(Color.white), 0, 2);
        board[0][3] = new Cell(new Queen(Color.white), 0, 3);
        board[0][4] = new Cell(new King(Color.white), 0, 4);
        board[0][5] = new Cell(new Bishop(Color.white), 0, 5);
        board[0][6] = new Cell(new Knight(Color.white), 0, 6);
        board[0][7] = new Cell(new Rook(Color.white), 0, 7);

        for (int i = 0; i < size; i++) {
            board[1][i] = new Cell(new Pawn(Color.white), 0, i);
        }

        board[7][0] = new Cell(new Rook(Color.black), 7, 0);
        board[7][1] = new Cell(new Knight(Color.black), 7, 1);
        board[7][2] = new Cell(new Bishop(Color.black), 7, 2);
        board[7][3] = new Cell(new Queen(Color.black), 7, 3);
        board[7][4] = new Cell(new King(Color.black), 7, 4);
        board[7][5] = new Cell(new Bishop(Color.black), 7, 5);
        board[7][6] = new Cell(new Knight(Color.black), 7, 6);
        board[7][7] = new Cell(new Rook(Color.black), 7, 7);

        for (int i = 0; i < size; i++) {
            board[6][i] = new Cell(new Pawn(Color.black), 6, i);
        }


        for (int i = 2; i < size - 2; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(null, i, j);
            }
        }
    }

    /**
     *
     * @param initialLine - linia de pe care se muta o piesa;
     * @param initialColumn - coloana de pe care se muta o piesa;
     * @param finalLine - linia pe care va fi mutata;
     * @param finalColumn - coloana pe care va fi mutata;
     *
     * In aceasta metoda se muta o piesa de pe o pozitie initiala pe una finala,
     * pozitia din care a fost mutata se seteaza pe null.
     */
    public void movePiece(Integer initialLine, Integer initialColumn,
                          Integer finalLine, Integer finalColumn) {

        Piece pieceToMove = board[initialLine][initialColumn].getPiece();
        board[finalLine][finalColumn] = new Cell(pieceToMove, finalLine, finalColumn);
        board[initialLine][initialColumn] = new Cell(null, initialLine, initialColumn);
    }
}