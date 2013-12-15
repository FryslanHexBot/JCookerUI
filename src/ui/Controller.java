package ui;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ComboBox FoodComboBox;
    @FXML
    Rectangle useStoveRectangle;
    @FXML
    ComboBox stoveLocationComboBox;
    @FXML
    Rectangle CloseRecatangle;
    @FXML
    Rectangle saveSettingsRectangle;
    @FXML
    Rectangle startRectangle;
    @FXML
    Rectangle loadSettingsRectangle;
    @FXML
    Label saveSettingsLabel;
    @FXML
    Label startLabel;
    @FXML
    Label loadSettingsLabel;

    private static final String[] food = {"Shrimp","Anchovies","Trout","Salmon","Tuna","Lobster","Swordfish","Monkfish","Shark"};
    private static final String[] locations = {"Edgeville","Catherby","Al-Kharid"};
    public static boolean useStove = false;
    public static String getSelectedFood;
    public static String getSelectedStoveLocation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Populate the FoodComboBox
        FoodComboBox.getItems().addAll(food);

        //Populate the stoveLocationComboBox
        stoveLocationComboBox.getItems().addAll(locations);

        //Handle closeRectangle
        //Closes the interface when clicked
        CloseRecatangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage stage = (Stage) Main.r.getScene().getWindow();
                stage.close();
            }
        });

        //Changes color when entered
        CloseRecatangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CloseRecatangle.setFill(Color.web("#ffb800"));
            }
        });

        //Changes back the color when Exitted
        CloseRecatangle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CloseRecatangle.setFill(Color.web("#404040"));
            }
        });

        // Handle useStoveRectangle
        // returns True if selected
        useStoveRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               if(useStove == false){
                   useStove = true;
                   useStoveRectangle.setFill(Color.web("#ffb800"));
                   stoveLocationComboBox.setDisable(false);
               } else {
                   useStove = false;
                   useStoveRectangle.setFill(Color.web("#404040"));
                   stoveLocationComboBox.setDisable(true);
               }
            }
        });

        //Cahnges the color when entered
        loadSettingsLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                loadSettingsRectangle.setOpacity(1.0);
            }
        });

        //Changes back the color when Exitted
        loadSettingsLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                loadSettingsRectangle.setOpacity(0.65);
            }
        });

        loadSettingsLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                //TODO handle load settings;
            }
        });

        //Cahnges the color when entered
        saveSettingsLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                saveSettingsRectangle.setOpacity(1.0);
            }
        });

        //Changes back the color when Exitted
        saveSettingsLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                saveSettingsRectangle.setOpacity(0.65);
            }
        });

        saveSettingsLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                //TODO handle save settings;
            }
        });

        //Changes the color when entered
        startLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                startRectangle.setOpacity(1.0);
            }
        });

        //Changes back the color when Exitted
        startLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                startRectangle.setOpacity(0.65);
            }
        });



        startLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                //Set selected food
                if(FoodComboBox.getSelectionModel().getSelectedItem().toString() != null){
                    getSelectedFood = FoodComboBox.getSelectionModel().getSelectedItem().toString();
                }

                //Set Stove Location
                if(stoveLocationComboBox.getSelectionModel().getSelectedItem().toString() != null){
                    getSelectedStoveLocation = FoodComboBox.getSelectionModel().getSelectedItem().toString();
                }

                //close the interface
                Stage stage = (Stage) Main.r.getScene().getWindow();
                stage.close();
            }
            });
    }
}
