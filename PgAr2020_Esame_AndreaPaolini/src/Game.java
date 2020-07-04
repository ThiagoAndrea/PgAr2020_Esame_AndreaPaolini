import java.util.Collections;

public class Game {

    Utility util = new Utility();

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
     *
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
     *
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
     * Metodo che mi decreta la fine della partita
     *
     * @param player1 primo giocatore in partita
     * @param player2 secondo giocatore in partita
     * @return vero se la partita è finita, falso altrimenti
     */
    public boolean victory(Player player1, Player player2) {
        if (player1.getHand().size() == 0 || player2.getHand().size() == 0) {
            return true;
        } else return false;
    }

    /**
     * Metodo fondamentale del gioco, verifica come è strutturato il turno
     *
     * @param player giocatore di turno
     * @param deck   mazzo utilizzato
     */
    public void turn(Player player, Deck deck) {
        System.out.println(player.getNickname() + Utility.YOUR_TURN);
        util.next();
        boolean doSomething = false;
        Card chosenCard;
        Card cardFacedUp = deck.getDiscardPile().peek();
        int count = 0;
        int i = 0;

        do {
            for (Card evalCard : player.getHand()) {
                if (sameColour(evalCard, cardFacedUp) || sameValue(evalCard, cardFacedUp))
                    doSomething = true;
            }
            if (doSomething) {
                do {
                    i++;
                    if (i != 1) {
                        System.out.println(Utility.ERROR_CARD); //Se non scegli la carta corretta, esce il messaggio di errore
                    }
                    chosenCard = player.chooseACard();

                } while (!sameValue(chosenCard, cardFacedUp) && !sameColour(chosenCard, cardFacedUp));
                player.discard(chosenCard, deck);
                count = 1;
            } else {
                if (count == 0) { //Devo pescare la carta solo se non l'ho ancora fatto all'interno del mio turno
                    System.out.println(Utility.YOU_MUST_DRAW);
                    util.next();
                    player.draw(deck);
                    player.printHand();
                    util.next();
                }
            }
            count++;
        } while (count == 1);


    }

    /**
     * Metodo che prdouce il gioco
     *
     * @param player1 giocatore 1
     * @param player2 giocatore 2
     * @param deck    mazzo in uso
     */
    public void battle(Player player1, Player player2, Deck deck) {
        do {
            System.out.println(Utility.CARD_ON_TABLE + deck.getDiscardPile().peek());
            turn(player1, deck);
            util.next();
            if (player1.getHand().size() == 0)
                break;
            System.out.println(Utility.CARD_ON_TABLE + deck.getDiscardPile().peek());
            util.next();
            turn(player2, deck);
            if (player2.getHand().size() == 0)
                break;
            util.next();
            System.out.println(Utility.CARD_ON_TABLE + deck.getDiscardPile().peek());
            util.next();
        } while (!victory(player1, player2));

    }


}
