import stateOfGame.StateOfGame;
import stateOfGame.CommandType;
import stateOfGame.Move;
import writeStateOfGame.WriteOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clasa Main - entry point-ul al motorului de sah, tot aici
 * se realizeaza comunicarea dintre acest motor de sah si Xboard.
 *
 * Interfata cu Xboard functioneaza astfel:
 *
 * - toate comenzile sunt citite de la stdout-ul Xboard-ului cu un BufferedReader,
 *   iar engine-ul afiseaza comenzile/mutarile la stdin-ul acestuia;
 *
 * - prima data se verifica daca Xboard a trimis comanda "xboard",
 *   acesta inceamna ca s-a stabilit conexiunea cu interfata si se poate continua,
 *   altfel se termina executia programului;
 *
 * - intr-o bucla se citesc toate comenzile trimise de Xboard, pana nu
 *   se trimite comada "quit", acesta insemnand ca interfata a fost inchisa si
 *   trebuie sa inceteze si executia motorului de sah;
 *
 * Comenzile primite de la Xboard si interpretate sunt urmatoarele:
 *
 *      * new - a inceput un joc nou, se seteaza automat ca motorul de sah o sa
 *              mute piese negre, se initializeaza tabla de sah;
 *      * protover N - in urma acestei comezi printeaza niste feature: "san = 0",
 *              "sigint = 0", "myname = NUME", astfel ii spunem interfetei ca o sa
 *              trimitem/primim comenzi in formatul "e2e4", dezactivam semnalele
 *              force trimise de xboard si setam numele jucatorului;
 *      * force - dupa acesta comanda se citesc toate mutarile trimise de la xboard
 *              si se duce evidenta cine este urmatorul la mutare si cu ce culoare
 *              o sa joace;
 *      * go - aceasta comanda este urmata de o mutare a motorului de sah, pentru
 *              jucatorul care este la mutare si va juca pentru acest jucator pana
 *              la urmatoare modificare;
 *      * move - reprezinta mutarile trimise de la xboard in format "e2e4" care sunt
 *              relizate si pe tabla interna a motorului de sah;
 *      * quit - se inceteaza executia programului;
 *
 * Comenzile trimise la xboard:
 *
 *      * feature - se trimit featurile corespunzatoare;
 *      * move "e2e4" - se trimit miscarile pe care le realizeaza motorul de sah;
 *      * resign - se cedeaza partida;
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        String command;
        StateOfGame stateOfGame = new StateOfGame();
        Move move = new Move();
        WriteOutput writeOutput = new WriteOutput();


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(input);

        command = bufferedReader.readLine();
        writeOutput.writeMessage(command);
        if (command.equals(CommandType.xboard.toString())) {

            while (!command.equals(CommandType.quit.toString())) {
                command = bufferedReader.readLine();
                writeOutput.writeMessage(command);

                if (command.contains(CommandType.protover.toString())) {
                    System.out.println("feature myname=\"Player1\"");
                    System.out.println("feature san=0");
                    System.out.println("feature sigint=0");
                }

                if (command.equals(CommandType.force.toString())) {
                    command = bufferedReader.readLine();
                    while (move.verifyMove(command)) {
                        writeOutput.writeMessage(command);
                        move.xboardMove(stateOfGame, writeOutput);
                        command = bufferedReader.readLine();
                    }

                    writeOutput.writeMessage(command);
                }

                if (command.equals("new")) {
                    stateOfGame.initBoard();
                }

                if (command.equals(CommandType.go.toString())) {
                    stateOfGame.engineMove(writeOutput);
                }

                if (move.verifyMove(command)) {
                    move.xboardMove(stateOfGame, writeOutput);
                    stateOfGame.engineMove(writeOutput);

                }
            }
        }

        writeOutput.close();
        bufferedReader.close();
        input.close();
    }
}
