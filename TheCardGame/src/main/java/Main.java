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

    sumText = new Text("Value of all your cards: " + calculateHandSum());

    Button dealButton = new Button("Deal new cards");
    dealButton.setOnAction(e -> dealNewHand());



    root.getChildren().addAll(title, cardBox, sumText, dealButton);

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
    sumText.setText("Value of all your cards: " + calculateHandSum());
  }

  private int calculateHandSum() {
    int sum = 0;
    for (PlayingCard card : hand) {
      sum += card.getFace();
    }
    return sum;
  }

  public static void main(String[] args) {
    launch(args);
  }
}

