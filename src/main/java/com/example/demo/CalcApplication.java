package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalcApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Label num1Label = new Label("Number 1:");
        TextField num1Field = new TextField();
        Label num2Label = new Label("Number 2:");
        TextField num2Field = new TextField();
        Label operationLabel = new Label("Operation:");
        ComboBox<String> operationBox = new ComboBox<>();
        operationBox.getItems().addAll("+", "-", "*", "/");
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label("Result:");
        TextField resultField = new TextField();
        resultField.setEditable(false);

        calculateButton.setOnAction(event -> {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            String operation = operationBox.getValue();
            double result = 0;
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            resultField.setText(String.valueOf(result));
        });
//
        root.add(num1Label, 0, 0);
        root.add(num1Field, 1, 0);
        root.add(num2Label, 0, 1);
        root.add(num2Field, 1, 1);
        root.add(operationLabel, 0, 2);
        root.add(operationBox, 1, 2);
        root.add(calculateButton, 1, 3);
        root.add(resultLabel, 0, 4);
        root.add(resultField, 1, 4);

        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
}
