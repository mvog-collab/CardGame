import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

  public List<PlayingCard> dealHand(int n) {
    if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("Number of cards to deal must be between 1 and 52");
    }

    Random rand = new Random();
    Collections.shuffle(deck, rand);  //blander kortene

    List<PlayingCard> hand = new ArrayList<PlayingCard>();
    for (int i = 0; i < n; i++) {
      hand.add(deck.get(i));
    }
    return hand;
  }


}