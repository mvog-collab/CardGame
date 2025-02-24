import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
  private ArrayList<PlayingCard> deck;
  private final char[] suits = { 'H', 'S', 'C', 'D'}; //  hjerter, spar, kløver og ruter

  public DeckOfCards() {
    this.deck = new ArrayList<PlayingCard>();
    for (char suit : suits) {
      for (int rank = 0; rank < 13; rank++) {
        deck.add(new PlayingCard(suit, rank));
      }
    }
  }
}