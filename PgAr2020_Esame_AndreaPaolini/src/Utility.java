import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    public static final String WHICH_DECK = "Quale mazzo volete utilizzare? Selezionare uno dei seguenti:\n0 ->nucleoBaseUnoGiOh\n1 ->Uno_Gi_OhConPescaDue" +
            "\n2 ->UnoGiOhCarteSpeciali \n3 -> UnoGiOhSenzaCarteNonColorate";
    public static final String YOUR_HAND = "Questa è la tua mano:\n";
    public static final String ERROR = "numero inserito non valido\n";
    public static final String FORMAT_ERROR = "Tipo di dato inserito non valido\n";


    public static int readFromKeyboard(int maxValue) {
        Scanner reader = new Scanner(System.in);
        boolean good = false;
        int numberChosen;
        do {
            numberChosen = reader.nextInt();
            try {
                if (numberChosen <= maxValue && numberChosen >= 0)
                    good = true;
                else {
                    System.out.println(ERROR);
                    good = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(FORMAT_ERROR);
                String badFormat = reader.next();
            }
        } while (!good);
        return numberChosen;
    }
}

