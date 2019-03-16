import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }


    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        Pane pane = fxmlLoader.load();
        Scene scene = new Scene (pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kalkulator");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
