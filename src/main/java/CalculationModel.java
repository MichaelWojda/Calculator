import javafx.beans.property.SimpleStringProperty;

public class CalculationModel {

    SimpleStringProperty display = new SimpleStringProperty("0");

    double firstNumber;
    double secondNumber;
    String action;
    Boolean afterResult = false;





    public void insertCharacter(String character){
        if(afterResult==true){
            setDisplay("0");
        }
        StringBuilder stringBuilder = new StringBuilder(display.get());
        if(stringBuilder.charAt(0)=='0' && stringBuilder.length()==1){
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(character);
        }
        else if(stringBuilder.charAt(0)=='/' || stringBuilder.charAt(0)=='*' || stringBuilder.charAt(0)=='+' || (stringBuilder.charAt(0)=='-' && stringBuilder.length()==1)){

            stringBuilder.deleteCharAt(0);
            stringBuilder.append(character);

        }
        else {
            stringBuilder.append(character);
        }

        display.set(stringBuilder.toString());
        afterResult =false;

    }

    public void insertDot(){
        StringBuilder stringBuilder = new StringBuilder(display.get());
        Boolean exist = false;
        for(int i =0; i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i)=='.'){
                exist=true;
            }
        }
        if(exist==false && ((!display.get().equals("/") && !display.get().equals("*") && !display.get().equals("+") && !display.get().equals("-"))))
        {
            stringBuilder.append(".");
            display.set(stringBuilder.toString());
        }
    }
    public void selectAction(String sign){
        if(!display.get().equals("/") && !display.get().equals("*") && !display.get().equals("+") && !display.get().equals("-")){
            this.setFirstNumber(Double.valueOf(display.get()));
            display.set(sign);
            this.setAction(sign);}

        else {
            display.set(sign);
            this.setAction(sign);
        }
    }

    public void equals(){
        setSecondNumber(Double.valueOf(display.get()));
        if(getAction().equals("+")){
            double result = firstNumber + secondNumber;
            display.set(String.valueOf(result));
            this.setFirstNumber(result);
        }
        if(getAction().equals("*")){
            double result = firstNumber * secondNumber;
            display.set(String.valueOf(result));
            this.setFirstNumber(result);
        }
        if(getAction().equals("/")){
            if(secondNumber==0){
                Dialogs.errorDialog("Błąd dzielenia przez 0");
                firstNumber=0;
                secondNumber=0;
                setDisplay("0");
            }
            else {
                double result = firstNumber / secondNumber;
                display.set(String.valueOf(result));
                this.setFirstNumber(result);
            }
        }
        if(getAction().equals("-")){
            double result = firstNumber-secondNumber;
            display.set(String.valueOf(result));
            this.setFirstNumber(result);
        }
        this.afterResult=true;

    }

    public void insertMinus(){
        StringBuilder stringBuilder = new StringBuilder(this.getDisplay());
        if (stringBuilder.length()==1 && (stringBuilder.charAt(0)=='0')){
            this.setFirstNumber(Double.valueOf(display.get()));
            stringBuilder.deleteCharAt(0);
            stringBuilder.append("-");
            this.setAction("-");
            setDisplay(stringBuilder.toString());
        }
        else {
            this.setFirstNumber(Double.valueOf(display.get()));
            display.set("-");
            this.setAction("-");
        }

    }



    public String getDisplay() {
        return display.get();
    }

    public SimpleStringProperty displayProperty() {
        return display;
    }

    public void setDisplay(String display) {
        this.display.set(display);
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


}
