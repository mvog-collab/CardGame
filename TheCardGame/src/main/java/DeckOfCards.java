import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.scene.text.Text;

public class DeckOfCards {
  private ArrayList<PlayingCard> deck;
  private final char[] suits = { 'H', 'S', 'C', 'D'}; //  hjerter, spar, kløver og ruter
  Random rand = new Random();


  public DeckOfCards() {
    initializeDeck();
  }

  public void initializeDeck() {
    deck = new ArrayList<>();
    for (char suit : suits) {
      for (int rank = 1; rank <= 13; rank++) {
        deck.add(new PlayingCard(suit, rank));
      }
    }
    shuffleDeck();
  }


  private void shuffleDeck() {
    Collections.shuffle(deck, rand);
  }

  public List<PlayingCard> dealHand(int n) {
    if (n < 1 ) {
      throw new IllegalArgumentException("Number of cards to deal must be at least 1");
    }
    if (deck.size() < n) {
      initializeDeck();
    }

    List<PlayingCard> hand = new ArrayList<PlayingCard>();
    for (int i = 0; i < n; i++) {
      hand.add(deck.remove(0));
    }
    return hand;
  }
}