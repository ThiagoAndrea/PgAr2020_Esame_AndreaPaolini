public class Main {
    public static void main(String[] args) {

        InputOutput input = new InputOutput();
        Deck deck = new Deck();
        Game match = new Game();
        Player player1 = new Player();
        Player player2 = new Player();

        input.initReader("Uno_Gi_OhConPescaDue.xml");
        input.readXML(deck.getCurrentDeck());
        match.shuffleDeck(deck);

        for (Card evalCard : deck.getCurrentDeck()) {
            System.out.println(evalCard.toString());
        }

        match.cardsDeliver(deck, player1, player2);
        match.firstCard(deck);
        System.out.println(player1.getHand().toString());
        System.out.println(player2.getHand().toString());
        System.out.println("mazzo degli scarti: " + deck.getDiscardPile().peek());


    }
}
