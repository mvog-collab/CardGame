import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {
    // Opprett en tekstkomponent som vises i vinduet
    Text helloText = new Text("Hello, JavaFX!");

    // Opprett en layout (StackPane)
    StackPane root = new StackPane();
    root.getChildren().add(helloText);

    // Opprett en Scene med layouten
    Scene scene = new Scene(root, 400, 300); // 400x300 er størrelsen på vinduet

    // Sett scenen til vinduet
    stage.setScene(scene);

    // Sett tittelen på vinduet
    stage.setTitle("JavaFX Application");

    // Vis vinduet
    stage.show();
  }

  public static void main(String[] args) {
    launch(args); // Start JavaFX-applikasjonen
  }
}
