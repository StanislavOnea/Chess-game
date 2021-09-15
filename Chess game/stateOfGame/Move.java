package stateOfGame;

import pieces.Color;
import writeStateOfGame.WriteOutput;
import java.io.IOException;

public class Move {
    private Integer initialColumn;
    private Integer initialLine;
    private Integer finalColumn;
    private Integer finalLine;

    /**
     * Returneaza true daca stringul reprezinta o mutare facuta
     * de adversar.
     */
    public Boolean verifyMove(String command) {
        if (command.length() == 4 || command.length() == 5) {
            this.initialColumn = command.charAt(0) - 97;
            this.initialLine= command.charAt(1) - 49;
            this.finalColumn = command.charAt(2) - 97;
            this.finalLine = command.charAt(3) - 49;
        } else {
            return false;
        }

        return this.initialColumn >= 0 && this.initialColumn <= 7
                && this.initialLine >= 0 && this.initialLine <= 7
                && this.finalColumn >= 0 && this.finalColumn <= 7
                && this.finalLine >= 0 && this.finalLine <= 7;
    }

    /**
     * Printeaza o mutare facuta de bot.
     */
    public void printMove(Integer initialLine, Integer initialColumn,
                          Integer finalLine, Integer finalColumn, char promotion) {
        char c1 = (char) (initialColumn + 97);
        char c2 = (char) (initialLine + 49);
        char c3 = (char) (finalColumn + 97);
        char c4 = (char) (finalLine + 49);

        if (promotion == '0') {
            System.out.println("move " + c1 + c2 + c3 + c4);
        } else {
            System.out.println("move " + c1 + c2 + c3 + c4 + promotion);
        }
    }

    /**
     * Se realizeaza mutarea facuta de abversar, se verifica daca a facut en
     * passant, daca un pion a fost promovat.
     */
    public void xboardMove(StateOfGame stateOfGame, WriteOutput writeOutput) throws IOException {
        stateOfGame.getBoard().movePiece(this.initialLine, this.initialColumn,
                this.finalLine, this.finalColumn);

        stateOfGame.getEnPassant().checkEnPassant(stateOfGame.getBoard(),
                this.finalLine, this.finalColumn, stateOfGame.getTurn());

        stateOfGame.getEnPassant().setX0(this.finalLine);
        stateOfGame.getEnPassant().setY0(this.finalColumn);
        stateOfGame.checkPromote(this.finalLine, this.finalColumn, writeOutput);
        stateOfGame.getChessCast().checkChessCast(stateOfGame.getBoard(),
                initialLine, initialColumn, finalLine, finalColumn);

        if (stateOfGame.getTurn().equals(Color.white)) {
            stateOfGame.setTurn(Color.black);
        } else {
            stateOfGame.setTurn(Color.white);
        }
        stateOfGame.getEnPassant().enPassant(stateOfGame);
        writeOutput.writeBoard(stateOfGame.getBoard());
   }

}
