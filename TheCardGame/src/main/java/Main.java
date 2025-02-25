import static javafx.application.Application.launch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;

public class Main extends Application {
  private DeckOfCards deck;
  private List<PlayingCard> hand;
  private HBox cardBox;
  private Text sumText;
  private Text flushStraightText;
  private Text sameOfKindText;

  @Override
  public void start(Stage stage) {
    stage.setTitle("GameOfCards");

    // Opprett en kortstokk og trekk 5 kort
    deck = new DeckOfCards();
    hand = deck.dealHand(5);

    // Opprett en layout
    VBox root = new VBox(20);
    root.setAlignment(Pos.CENTER);
    root.setStyle("-fx-padding: 20px;");

    Text title = new Text("Your cards");

    // Vis kortene i en horisontal layout
    cardBox = new HBox(15);
    cardBox.setAlignment(Pos.CENTER);
    updateHand();

    sumText = new Text("Sum: " + calculateHandSum());
    flushStraightText = new Text(checkForFlush());
    sameOfKindText = new Text(checkForSameKind());

    Button dealButton = new Button("Deal Cards");
    dealButton.setOnAction(e -> dealNewHand());

    root.getChildren().addAll(title, cardBox, sumText, flushStraightText, sameOfKindText, dealButton);

    Scene scene = new Scene(root, 600, 400);
    stage.setScene(scene);
    stage.show();
  }

  private void updateHand() {
    cardBox.getChildren().clear();
    for (PlayingCard card : hand) {
      cardBox.getChildren().add(CardRenderer.createCardImage(card));
    }
  }

  private void dealNewHand() {
    hand = deck.dealHand(5);
    updateHand();
    sumText.setText("Sum: " + calculateHandSum());
    flushStraightText.setText(checkForFlush());
    sameOfKindText.setText(checkForSameKind());
  }

  private int calculateHandSum() {
    int sum = 0;
    for (PlayingCard card : hand) {
      sum += card.getFace();
    }
    return sum;
  }

  private String checkForFlush() {
    AnalyseHand analyse = new AnalyseHand(hand);
    int flush = AnalyseHand.checkFlush();
    int straight = AnalyseHand.checkStraight(hand);

    if (flush > 0 && straight > 0) return "You got a Straight Flush!";
    if (flush > 0) return "You got a Flush!";
    if (straight > 0) return "You got a Straight!";
    return "Level Hard: Keep dealing hand to get a Straight or Flush!";
  }

  private String checkForSameKind() {
    AnalyseHand analyse = new AnalyseHand(hand);

    if (analyse.isOfAKind(4)==4) {
      return "You have Four of a Kind!";
    } else if (analyse.isOfAKind(3)==3) {
      return "You have Three of a Kind!";
    } else if (analyse.isOfAKind(2)==2) {
      return "You have Two of a Kind!";
    }
    return "Level Easy: No two, three, or four of the same kind";
  }

  public static void main(String[] args) {
    launch(args);
  }
}
