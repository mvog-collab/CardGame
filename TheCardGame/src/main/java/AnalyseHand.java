import java.util.List;

public class AnalyseHand {


  public static boolean isFlush(List<PlayingCard> hand) {
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
