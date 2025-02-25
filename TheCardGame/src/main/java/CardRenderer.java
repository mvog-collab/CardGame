import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class CardRenderer {

  /**
   * Oppretter en visuell representasjon av et kort ved hjelp av et ikon og en tekst.
   */
  public static StackPane createCardImage(PlayingCard card) {
    // Hent ikon basert på kortets farge
    String suitImagePath = getSuitImage(card.getSuit());
    Image suitImage = new Image(CardRenderer.class.getResource(suitImagePath).toExternalForm());
    ImageView suitIcon = new ImageView(suitImage);
    suitIcon.setFitWidth(50);
    suitIcon.setFitHeight(50);

    // Lag en tekst for tallet på kortet
    Text faceText = new Text(getCardFaceValue(card.getFace()));
    faceText.setFont(Font.font("Arial", 20));
    faceText.setFill(Color.BLACK);

    // Plasser tallet oppe i hjørnet
    StackPane cardPane = new StackPane();
    cardPane.getChildren().addAll(suitIcon, faceText);
    StackPane.setAlignment(faceText, Pos.TOP_LEFT);
    StackPane.setAlignment(suitIcon, Pos.CENTER);

    cardPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-background-color: white;");
    cardPane.setPrefSize(100, 150);

    return cardPane;
  }

  /**
   * Returnerer riktig bildefil for kortets farge.
   */
  private static String getSuitImage(char suit) {
    return "/images/" + switch (suit) {
      case 'H' -> "Hearts.png";
      case 'S' -> "Spades.png";
      case 'D' -> "Diamonds.png";
      case 'C' -> "Clubs.png";
      default -> "unknown.png";
    };
  }

  /**
   * Konverterer kortverdi til tekstrepresentasjon.
   */
  private static String getCardFaceValue(int face) {
    return switch (face) {
      case 1 -> "A";
      case 11 -> "J";
      case 12 -> "Q";
      case 13 -> "K";
      default -> String.valueOf(face);
    };
  }
}
