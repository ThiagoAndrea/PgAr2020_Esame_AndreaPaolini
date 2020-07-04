public class Main {
    public static void main(String[] args) {

        InputOutput input = new InputOutput();
        Deck deck = new Deck();
        Game match = new Game();
        Utility util = new Utility();
        Player player1 = new Player();
        Player player2 = new Player();
        Player firstPlayer;
        Player secondPlayer;

        //Istruzioni
        util.start();
        //Inserimento del nome dei giocatore, se sono uguali, rifare.
        do {
            System.out.println(Utility.FIRST_PLAYER_NAME);
            player1.setNickname(util.readStringFromKeyboard());
            System.out.println(Utility.SECOND_PLAYER_NAME);
            player2.setNickname(util.readStringFromKeyboard());
        } while (player1.getNickname().equalsIgnoreCase(player2.getNickname()));

        //Scelta del mazzo
        deck.whichDeck();

        //Scelta del primo giocatore
        int player1Dice;
        int player2Dice;
        do {
            player1Dice = player1.rollADice();
            System.out.println(player1.getNickname() + Utility.ROLL_A_DICE);
            util.next();
            System.out.println(player1Dice);
            util.next();
            player2Dice = player2.rollADice();
            System.out.println(player2.getNickname() + Utility.ROLL_A_DICE);
            util.next();
            System.out.println(player2Dice);
        } while (player1Dice == player2Dice);
        if (player1Dice > player2Dice) {
            firstPlayer = player1;
            secondPlayer = player2;
        } else {
            firstPlayer = player2;
            secondPlayer = player1;
        }

        System.out.println(Utility.FIRST_PLAYER + firstPlayer.getNickname());
        util.next();

        //Inizio partita
        match.shuffleDeck(deck);
        match.cardsDeliver(deck, firstPlayer, secondPlayer);
        match.firstCard(deck);

        System.out.println("Carta in tavola: " + deck.getDiscardPile().peek());

        //Scommesse
        firstPlayer.printHand();
        boolean bet1 = firstPlayer.wannaBet();
        if(bet1) firstPlayer.bet(secondPlayer, deck);
        secondPlayer.printHand();
        boolean bet2 = secondPlayer.wannaBet();
        if(bet2) secondPlayer.bet(firstPlayer, deck);

        match.battle(firstPlayer, secondPlayer, deck);
        if (firstPlayer.getHand().size() == 0) {
            System.out.println(Utility.THE_WINNER_IS + firstPlayer.getNickname());
        } else
            System.out.println(Utility.THE_WINNER_IS + secondPlayer.getNickname());
    }
}
