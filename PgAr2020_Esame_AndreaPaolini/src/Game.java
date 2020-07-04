import java.util.Collections;

public class Game {

    /**
     * Permette la distribuzione delle carte ai due giocatori: ogni giocatore ha 7 carte e sono distribuite una alla volta, partendo dalla cima del mazzo mescolato
     *
     * @param deck    mazzo dal quale distribuire le carte
     * @param player1 primo giocatore
     * @param player2 secondo giocatore
     */
    public void cardsDeliver(Deck deck, Player player1, Player player2) {
        do {
            int i = 0;
            Card evalcard1 = deck.getCurrentDeck().remove(i);
            player1.getHand().add(evalcard1);
            Card evalcard2 = deck.getCurrentDeck().remove(i);
            player2.getHand().add(evalcard2);
        } while (player1.getHand().size() < 7 && player2.getHand().size() < 7);
    }

    /**
     * Metodo che permette di mescolare il mazzo attraverso il collections.shuffle
     *
     * @param deck mazzo che si vuole mescolare
     */
    public void shuffleDeck(Deck deck) {
        Collections.shuffle(deck.getCurrentDeck());
    }

    /**
     * La prima carta viene presa casualmente dal deck, dopo aver consegnato le carte ai giocatori
     *
     * @param deck mazzo dal quale prendere la carta
     */
    public void firstCard(Deck deck) {
        int n = (int) (Math.random() * deck.getCurrentDeck().size());
        Card evalCard = deck.getCurrentDeck().remove(n);
        deck.getDiscardPile().add(evalCard);
    }

    /**
     * Verfica che due carte abbiano lo stesso colore
     * @param card1 prima carta
     * @param card2 seconda carta
     * @return true se hanno stesso valore, false altrimenti
     */
    public boolean sameColour(Card card1, Card card2) {
        if (card1.getColour().equalsIgnoreCase(card2.getColour()))
            return true;
        else return false;
    }

    /**
     * Metodo che verifica che due carte abbiano lo stesso valore
     * @param card1 prima carta
     * @param card2 seconda carta
     * @return true se hanno lo stesso valore, false altrimenti
     */
    public boolean sameValue(Card card1, Card card2) {
        if (card1.getNumber().equalsIgnoreCase(card2.getNumber()))
            return true;
        else return false;
    }

    /**
     * Metodo che scarta una carta dalla mano del giocatore e la mette in cima alla pila degli scarti
     * @param chosenCard carta scelta dal giocatore
     * @param deck mazzo in gioco
     * @param player giocatore di turno
     */
    public void discard(Card chosenCard, Deck deck, Player player) {
        deck.getDiscardPile().add(chosenCard);
        player.getHand().remove(chosenCard);
    }

    /**
     * Metodo che permette di pescare una carta dal mazzo
     * @param deck mazzo corrente
     * @param player giocatore che deve pescare
     */
    public void draw(Deck deck, Player player){
        Card evalCard = deck.getCurrentDeck().remove(0);
        player.getHand().add(evalCard);
    }




}
