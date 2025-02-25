import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    stage.setTitle("Kortspill");

    // Opprett en kortstokk og trekk 5 kort
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(5);

    // Opprett en layout
    VBox root = new VBox(20);
    root.setAlignment(Pos.CENTER);
    root.setStyle("-fx-padding: 20px;");

    Text title = new Text("Ditt kortbord");

    // Vis kortene i en horisontal layout
    HBox cardBox = new HBox(15);
    cardBox.setAlignment(Pos.CENTER);

    for (PlayingCard card : hand) {
      cardBox.getChildren().add(CardRenderer.createCardImage(card));
    }

    root.getChildren().addAll(title, cardBox);
    Scene scene = new Scene(root, 600, 400);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

