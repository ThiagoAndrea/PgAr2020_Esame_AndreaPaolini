import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Deck {


    private ArrayList<Card> allCards = new ArrayList<>();
    private Stack<Card> discardPile = new Stack<>();

    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Stack<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public void setAllCards(ArrayList<Card> allCards) {
        this.allCards = allCards;
    }

}
