import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    public static final String WHICH_DECK = "Quale mazzo volete utilizzare? Selezionare uno dei seguenti:\n0 -> nucleoBase\n1 -> Uno_Gi_OhConPescaDue" +
            "\n2 -> bigDeck (160 carte per un divertimento assicurato!) \n3 -> magicNumber7 (il deck con il numero fortunato: sono 4 le carte con il numero 7!)";
    public static final String GENERIC_CARD_COLOUR = "Scegli un colore:\n0--> rosso\n1--> blu\n2-->verde\n3-->giallo";
    public static final String GENERIC_CARD_NUMBER = "Scegli un numero tra 0 e 9";
    public static final String YOUR_HAND = "Questa è la tua mano, scegli quale carta scartare:\n";
    public static final String ERROR = "Numero inserito non valido, riprova:\n";
    public static final String FORMAT_ERROR = "Tipo di dato inserito non valido, riprova:\n";
    public static final String THE_WINNER_IS = "Il vincitore di questa partita è ";
    public static final String YOUR_TURN = ", è il tuo turno: ";
    public static final String ERROR_CARD = "La carta scelta non può essere scartata.";
    public static final String YOU_MUST_DRAW = "Ti tocca pescare!";
    public static final String ROLL_A_DICE = ", tira il dado";
    public static final String FIRST_PLAYER_NAME = "Inserire il nome del primo giocatore: ";
    public static final String SECOND_PLAYER_NAME = "Inserire il nome del secondo giocatore: ";
    public static final String FIRST_PLAYER = "Il primo giocatore sarà ";
    public static final String WANNA_BET = " premi 1 se vuoi scommettere, 0 altrimenti:";
    public static final String FAIL = "Scommessa persa! Pesca una carta.";
    public static final String CARD_ON_TABLE = "La carta in tavola è: ";
    public static final String RIGHTBET = "Complimenti! Hai vinto la scommessa!";
    public static final String INTRODUCTION = "Benvenuti al tavolo di Uno-Gi-Oh!\nLe regole di questo gioco sono molto semplici, e sono basate sul tipico gioco Uno, famoso in tutto\n" +
            "il mondo. Un paio di regole in più: a inizio partita c'è la possibilità di scommettere: potete indicare una carta che pensate che il vostro avversario abbia in mano;\n" +
            "se indovinate la carta, ne potrete scartare una a vostra scelta dalla mano, altrimenti vi tocca pescare. A inizio partita sarete voi a scegliere con quale mazzo giocare.\n" +
            "Quando vedrete questo simbolo \\n significa che dovete premere invio per passare al turno successivo." ;
    public static final String FRAME = "**************************************************************";

    Scanner reader = new Scanner(System.in);


    /**
     * Verifica che il numero inserito da tastiera sia positivo e minore di un valore massimo
     *
     * @param maxValue Valore massimo
     * @return numero correttamente insetito
     */
    public int readFromKeyboard(int maxValue) {

        boolean good = false;
        int numberChosen = 0;
        do {
            try {
                numberChosen = reader.nextInt();
                if (numberChosen <= maxValue && numberChosen >= 0)
                    good = true;
                else {
                    System.out.println(ERROR);
                    good = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(FORMAT_ERROR);
                String useless = reader.nextLine();
            }
        } while (!good);
        return numberChosen;
    }

    /**
     * Metodo utile per rendere chiaro il passaggio del turno
     */
    public void next() {
        System.out.println("\n\\n\n");
        reader.nextLine();
    }

    public String readStringFromKeyboard(){
        String name = null;
        boolean good = false;
        do {
            name = reader.nextLine();
            if (name.length() > 0)
                good = true;
        }while (!good);
        return  name;
    }

    public void start(){
        System.out.println(FRAME);
        System.out.println(INTRODUCTION);
        System.out.println(FRAME);
        next();
    }
}

