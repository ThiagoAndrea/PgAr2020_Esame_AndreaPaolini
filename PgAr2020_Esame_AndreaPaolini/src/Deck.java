import java.util.ArrayList;
import java.util.Stack;

/**
 * Classe che mi definisce un mazzo. All'interno ci sono tutti i possibili mazzi che si vogliono utilizzare
 */
public class Deck {



    private ArrayList<Card> currentDeck = new ArrayList<>();
    private Stack<Card> discardPile = new Stack<>();
    String[] types = {"blu", "rosso", "giallo", "verde"};
    Utility util = new Utility();
    InputOutput IO = new InputOutput();



    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    public ArrayList<Card> getCurrentDeck() {
        return currentDeck;
    }


    /**
     * Metodo che mi crea il mazzo doppio, 40 carte per colore.
     */
    public void bigDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                Card evalCard = new Card();
                evalCard.setColour(types[i]);
                evalCard.setNumber(String.valueOf(j));
                for (int count = 0; count < 4; count++) { //Aggiungo le stesse carte 4 volte
                    this.currentDeck.add(evalCard);
                }
            }
        }
    }

    /**
     * Metodo che crea il mazzo magic number 7 che ha 4 carte col numero 7 per ogni colore invece che 2
     */
    public void magicNumber7() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                Card evalCard = new Card();
                evalCard.setColour(types[i]);
                evalCard.setNumber(String.valueOf(j));
                for (int count = 0; count < 2; count++) {
                    this.currentDeck.add(evalCard);
                }
                if ((j) == 7) {
                    this.currentDeck.add(evalCard);
                    this.currentDeck.add(evalCard);
                }
            }
        }
    }

    /**
     * Metodo che mi permette di scegliere il deck in base alla preferenza dell'utente
     */
    public void whichDeck() {
        System.out.println(Utility.WHICH_DECK);
        int whichDeck = util.readFromKeyboard(4);
        switch (whichDeck) {
            case 0 -> {
                IO.initReader("nucleoBaseUnoGiOh.xml");
                IO.readXML(this.currentDeck);
            }
            case 1 -> {
                IO.initReader("Uno_Gi_OhConPescaDue.xml");
                IO.readXML(this.currentDeck);
            }
            case 2 -> bigDeck();
            case 3 -> magicNumber7();
        }
    }
}
