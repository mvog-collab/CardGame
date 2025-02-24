import java.util.List;

public class AnalyseHand {

  private List<PlayingCard> hand;

  // Konstruktør
  public AnalyseHand(List<PlayingCard> hand) {
    this.hand = hand;
  }

  // Metode for å sjekke for flush
  public boolean isFlush() {
    if (hand == null || hand.isEmpty()) {
      return false;
    }
    char firstSuit = hand.get(0).getSuit();

    for (PlayingCard card : hand) {
      if (card.getSuit() != firstSuit) {
        return false;
      }
    }
    return true;
  }
}
