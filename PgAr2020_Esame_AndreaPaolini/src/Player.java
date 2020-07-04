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


}
