import java.util.Collections;

public class Game {

    public void cardsDeliver (Deck deck, Player player1, Player player2)
    {

    }

    /**
     * Metodo che permette di mescolare il mazzo attraverso il collections.shuffle
     * @param deck mazzo che si vuole mescolare
     */
    public void shuffleDeck(Deck deck)
    {
        Collections.shuffle(deck.getAllCards());
    }
}
