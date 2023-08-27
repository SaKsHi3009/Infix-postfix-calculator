package javaapplication2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class calc extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Infix/Postfix Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        BackgroundFill bgFill = new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        grid.setBackground(new Background(bgFill));
        Label inputLabel = new Label("Enter Infix Expression:");
        GridPane.setConstraints(inputLabel, 0, 0);

        TextField inputField = new TextField();
        GridPane.setConstraints(inputField, 1, 0);

        Label directionLabel = new Label("Conversion Direction:");
        GridPane.setConstraints(directionLabel, 0, 1);

        ChoiceBox<String> directionChoiceBox = new ChoiceBox<>();
        directionChoiceBox.getItems().addAll("Infix to Postfix", "Postfix to Infix");
        directionChoiceBox.setValue("Infix to Postfix");
        GridPane.setConstraints(directionChoiceBox, 1, 1);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 1, 2);

        Label resultLabel = new Label("Result:");
        GridPane.setConstraints(resultLabel, 0, 3);

        Label resultValueLabel = new Label();
        GridPane.setConstraints(resultValueLabel, 1, 3);

        convertButton.setOnAction(e -> {
            String inputExpression = inputField.getText();
            String direction = directionChoiceBox.getValue();
            // Call your conversion logic here based on the direction
           JavaApplication2 jv=new JavaApplication2();
           
            String convertedExpression = jv.convertExpression(inputExpression, direction);
            resultValueLabel.setText(convertedExpression);
        });
        convertButton.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    directionChoiceBox.getSelectionModel().selectPrevious();
                    break;
                case DOWN:
                    directionChoiceBox.getSelectionModel().selectNext();
                    break;
                default:
                    break;
            }
        });
        grid.getChildren().addAll(
            inputLabel, inputField, directionLabel, directionChoiceBox,
            convertButton, resultLabel, resultValueLabel
        );

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Implement your conversion logic here
   
}
