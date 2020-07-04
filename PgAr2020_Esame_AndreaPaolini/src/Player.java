import java.util.ArrayList;
import java.util.Random;

/**
 * Classe che mi rappresenta il giocatore; caratterizzato da un nome, una mano di carte e il fatto che possa giocare il proprio turno
 */
public class Player {

    private String nickname;
    private ArrayList<Card> hand = new ArrayList<>();
    private boolean skipTurn = false;

    Utility util = new Utility();

    public boolean getSkipTurn() {
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    Game match = new Game();

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                '}';
    }

    public ArrayList<Card> getHand() {
        return hand;
    }


    /**
     * Metodo che ti permette di scegliere una carta dalla tua mano
     *
     * @return la carta scelta
     */
    public Card chooseACard() {
        Card chosenCard;
        int i = 0;
        System.out.println(Utility.YOUR_HAND);
        for (Card evalCard : hand) {
            System.out.println(i + " -> " + evalCard.toString());
            i++;
        }
        i = util.readFromKeyboard(hand.size() - 1);
        chosenCard = hand.get(i);
        return chosenCard;
    }

    /**
     * Metodo che permette di pescare una carta dal mazzo
     *
     * @param deck mazzo corrente
     */
    public void draw(Deck deck) {
        if (deck.getCurrentDeck().size() == 0) //Se non posso più pescare perché non c'è il mazzo, lo rimescolo.
        {
            Card firstCard = deck.getDiscardPile().peek();
            for (Card evalCard : deck.getDiscardPile()) {
                evalCard = deck.getDiscardPile().pop();
                deck.getCurrentDeck().add(evalCard);
            }
            match.shuffleDeck(deck);
            deck.getDiscardPile().add(firstCard); //Inserisco nuovamente la prima carta
            deck.getCurrentDeck().remove(firstCard);
        }
        Card evalCard = deck.getCurrentDeck().remove(0);
        hand.add(evalCard);
    }

    /**
     * Metodo che scarta una carta dalla mano del giocatore e la mette in cima alla pila degli scarti
     *
     * @param chosenCard carta scelta dal giocatore
     * @param deck       mazzo in gioco
     */
    public void discard(Card chosenCard, Deck deck) {

        deck.getDiscardPile().add(chosenCard);
        hand.remove(chosenCard);
    }

    /**
     * metodo che stampa la mano di un giocatore
     */
    public void printHand() {
        int i = 0;
        System.out.println(this.getNickname() + ":");
        for (Card evalCard : hand) {
            System.out.println(i + " -> " + evalCard.toString());
            i++;
        }
    }

    /**
     * Metodo che tira un dado per decretare il primo giocatore
     *
     * @return valore del dado
     */
    public int rollADice() {
        Random generator = new Random();
        return 1 + generator.nextInt(6);
    }

    /**
     * Metodo che serve per scommettere, fa scegliere all'utente una carta qualsiasi
     *
     * @return carta scelta dall'utente
     */
    public Card chooseAGenericCard() {
        Card genericCard = new Card();
        System.out.println(Utility.GENERIC_CARD_COLOUR);
        int generalColour = util.readFromKeyboard(3);
        String colour = switch (generalColour) {
            case 0 -> "rosso";
            case 1 -> "blu";
            case 2 -> "verde";
            case 3 -> "giallo";
            default -> "";
        };
        System.out.println(Utility.GENERIC_CARD_NUMBER);
        int generalNumber = util.readFromKeyboard(9);
        genericCard.setColour(colour);
        genericCard.setNumber(String.valueOf(generalNumber));
        return genericCard;
    }

    /**
     * @return true se il giocatore vuole scommettere, else altrimenti
     */
    public boolean wannaBet() {
        System.out.println(this.getNickname() + Utility.WANNA_BET);
        int decision = util.readFromKeyboard(1);
        return decision == 1;
    }

    /**
     * Metodo per la scommessa: se si sceglie una carta che ha in mano l'altro giocatore, se ne può scartare una dalla propria mano
     *
     * @param otherPlayer altro giocatore
     * @param deck        mazzo che si sta utilizzando
     */
    public void bet(Player otherPlayer, Deck deck) {
        Card chosen = chooseAGenericCard();
        boolean rightBet = false;
        for (Card evalCard : otherPlayer.getHand()) {
            if (chosen.getNumber().equalsIgnoreCase(evalCard.getNumber()) && chosen.getColour().equalsIgnoreCase(evalCard.getColour())) {
                rightBet = true;
                System.out.println(Utility.RIGHTBET);
                Card playerCard = chooseACard();
                discard(playerCard, deck);
            }
            }
        if(!rightBet) {
            System.out.println(Utility.FAIL);
            draw(deck);
        }
    }

}
