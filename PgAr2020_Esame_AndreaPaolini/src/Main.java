import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        InputOutput input = new InputOutput();
        Deck deck = new Deck();
        Game match = new Game();

        input.initReader("Uno_Gi_OhConPescaDue.xml");
        input.readXML(deck.getAllCards());
        match.shuffleDeck(deck);
        for (Card evalCard : deck.getAllCards()) {
            System.out.println(evalCard.toString());
        }


    }
}
