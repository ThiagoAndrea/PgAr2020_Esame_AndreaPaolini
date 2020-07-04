public class Card {


    private String colour;
    private String number; //Perché una stringa? Il numero della carta non ha valore al fine del gioco, serve solo come stringa; inoltre per le carte speciali


    @Override
    public String toString() {
        return "Card{" +
                "colour='" + colour + '\'' +
                ", number=" + number +
                '}';
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
