import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {


    @FXML
    private TextField resultWindow;

    @FXML
    private Button dotButton;

    private CalculationModel calculationModel;



    @FXML
    public void initialize(){
        calculationModel = new CalculationModel();
        this.resultWindow.textProperty().bindBidirectional(this.calculationModel.displayProperty());

    }

    @FXML
    void divideOnClick() {
        this.calculationModel.selectAction("/");

    }

    @FXML
    void dotOnClick() {
        this.calculationModel.insertDot();
        //this.dotButton.setDisable(true);
    }

    @FXML
    void eightOnClick() {
        this.calculationModel.insertCharacter("8");

    }

    @FXML
    void equalsOnClick() {
       this.calculationModel.equals();

    }

    @FXML
    void fiveOnClick() {
        this.calculationModel.insertCharacter("5");

    }

    @FXML
    void fourOnClick() {
        this.calculationModel.insertCharacter("4");

    }

    @FXML
    void minusOnClick() {
        this.calculationModel.insertMinus();

    }

    @FXML
    void multipleOnClick() {
        this.calculationModel.selectAction("*");

    }

    @FXML
    void nineOnClick() {
        this.calculationModel.insertCharacter("9");

    }

    @FXML
    void oneOnClick() {
        this.calculationModel.insertCharacter("1");

    }

    @FXML
    void plusOnClick() {
        this.calculationModel.selectAction("+");


    }

    @FXML
    void sevenOnClick() {
        this.calculationModel.insertCharacter("7");

    }

    @FXML
    void sixOnClick() {
        this.calculationModel.insertCharacter("6");

    }

    @FXML
    void threeOnClick() {
        this.calculationModel.insertCharacter("3");

    }

    @FXML
    void twoOnClick() {
        this.calculationModel.insertCharacter("2");

    }

    @FXML
    void zeroOnClick() {
        this.calculationModel.insertCharacter("0");

    }

    public void cancellOnClick() {
        this.calculationModel.setDisplay("0");
        this.calculationModel.setFirstNumber(0);
        this.calculationModel.setSecondNumber(0);
        this.calculationModel.setAction(null);
        this.dotButton.setDisable(false);
        this.calculationModel.setAction("");

    }
}

