import java.util.Collections;
import java.util.List;

public class AnalyseHand {

  private static List<PlayingCard> hand;

  // Konstruktør
  public AnalyseHand(List<PlayingCard> hand) {
    AnalyseHand.hand = hand;
  }

  // Metode for å sjekke for flush
  public static int isFlush() {
    if (hand == null || hand.isEmpty()) {
      return 0;
    }
    char firstSuit = hand.get(0).getSuit();

    for (PlayingCard card : hand) {
      if (card.getSuit() != firstSuit) {
        return 0;
      }
    }
    return 5;
  }

  public static int checkStraight(List<PlayingCard> hand) {
    hand.sort((card1, card2) -> card1.getFace() - card2.getFace());  // Sorter etter face

    for (int i = 0; i < hand.size() - 1; i++) {
      if (hand.get(i).getFace() + 1 != hand.get(i + 1).getFace()) {
        return 0;  // Ikke straight
      }
    }
    return 4;  // Straight gir 4 poeng
  }
}
