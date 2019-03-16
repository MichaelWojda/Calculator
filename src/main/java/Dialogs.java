import javafx.scene.control.Alert;

public class Dialogs {


    public static void errorDialog(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Błąd");
        alert.setTitle("Błąd");
        alert.setContentText(error);
        alert.showAndWait();


    }
}
