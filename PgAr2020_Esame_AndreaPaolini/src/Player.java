import java.util.ArrayList;

public class Player {


    private ArrayList<Card> hand = new ArrayList<>();

    @Override
    public String toString() {
        return "Player{" +
                "hand=" + hand +
                '}';
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public Card chooseACard() {
        Card chosenCard;
        int i = 0;
        System.out.println(Utility.YOUR_HAND);
        for (Card evalCard : hand) {
            System.out.println(i + evalCard.toString());
            i++;
        }
        i = Utility.readFromKeyboard(hand.size()-1);
        chosenCard = hand.get(i);
        return chosenCard;
    }

}
