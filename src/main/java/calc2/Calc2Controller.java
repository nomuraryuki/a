package calc2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Calc2Controller {
    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    @FXML
    private ComboBox<String> operationBox;
    @FXML
    private TextField resultField;

    @FXML
    private void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList("+", "-", "*", "/");
        operationBox.setItems(items);
    }

    @FXML
    public void calculate(ActionEvent actionEvent) {
        var num1Value = Double.parseDouble(num1.getText());
        var num2Value = Double.parseDouble(num2.getText());
        var operation = operationBox.getValue();
        var result = switch (operation) {
            case "+" -> num1Value + num2Value;
            case "-" -> num1Value - num2Value;
            case "*" -> num1Value * num2Value;
            case "/" -> num1Value / num2Value;
            default -> 0;
        };
        resultField.setText(String.valueOf(result));
    }
}
