import java.util.ArrayList;
import java.util.Stack;

public class Deck {


    private ArrayList<Card> currentDeck = new ArrayList<>();
    private Stack<Card> discardPile = new Stack<>();

    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Stack<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public ArrayList<Card> getCurrentDeck() {
        return currentDeck;
    }

    public void setCurrentDeck(ArrayList<Card> currentDeck) {
        this.currentDeck = currentDeck;
    }

}
