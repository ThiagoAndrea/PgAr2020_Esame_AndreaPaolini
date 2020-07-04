import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;

public class InputOutput {

    XMLInputFactory xmlif = null;
    XMLStreamReader xmlr = null;

    /**
     * Inizializzatore di un file xml
     *
     * @param nome_file nome del file che si vuole inizializzare
     */
    public void initReader(String nome_file) {

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(nome_file));
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
        }
    }

    /**
     * Lettore dell'xml
     *
     * @param deck salva i dati raccolti nel deck
     */
    public void readXML(ArrayList<Card> deck) {
        try {
            String evalcolour = null;

            int totalCards = 0;
            int j = 0;
            Card[] cards = new Card[totalCards];
            while (xmlr.hasNext()) {

                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) { // inizio di un elemento: stampa il nome del tag e i suoi attributi
                    if (xmlr.getLocalName().equalsIgnoreCase("mazzo"))
                        for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                            if ("numerodicarte".equals(xmlr.getAttributeLocalName(i))) {
                                cards = new Card[Integer.parseInt(xmlr.getAttributeValue(i))];
                                for (int m = 0; m < cards.length; m++) //Inizializzo il vettore di tutte le carte
                                    cards[m] = new Card();
                            }
                        }
                    for (int i = 0; i < xmlr.getAttributeCount(); i++) {

                        switch (xmlr.getAttributeLocalName(i)) {
                            case "colore" -> evalcolour = (xmlr.getAttributeValue(i));
                            case "valore" -> {
                                cards[j].setColour(evalcolour);
                                cards[j].setNumber((xmlr.getAttributeValue(i)));
                            }
                        }

                    }
                } else if (xmlr.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    if (xmlr.getLocalName().equalsIgnoreCase("carta"))
                        j++;
                }
                xmlr.next();
            }

            deck.addAll(Arrays.asList(cards));

        } catch (Exception e) {
            System.out.println("Errore nella lettura:");
        }

    }


}
