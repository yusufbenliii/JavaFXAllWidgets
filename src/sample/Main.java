
package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;

class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        //grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        //grid.setGridLinesVisible(true);  // to make grid lines visible to understand columns and rows better

        Label firstLabel = new Label("All Graphic Widgets in one");
        firstLabel.setFont(Font.font("Arial", FontWeight.BOLD,30));
        grid.add(firstLabel, 0, 0,2,1);  // column, row, columns, rows (columns and rows for extending label to multiple columns and rows)

        Text someText = new Text("Here is some text.... and a place to enter text");
        someText.setFont(Font.font("Arial",15));
        grid.add(someText, 0, 1,2,1);

        TextField myText = new TextField("This is my text");
        myText.setPrefWidth(400);
        myText.setFont(Font.font("Arial",15));
        grid.add(myText, 0, 2,2,1);

        CheckBox firstCheckbox = new CheckBox("My first checkbox!");
        firstCheckbox.setFont(Font.font("Arial",15));
        grid.add(firstCheckbox,0,3);

        CheckBox secondCheckbox = new CheckBox("My second checkbox!");
        secondCheckbox.setFont(Font.font("Arial",15));
        grid.add(secondCheckbox,1,3);
        GridPane.setHalignment(secondCheckbox, HPos.LEFT);

        RadioButton firstRadio = new RadioButton("My first Radio!");
        firstRadio.setFont(Font.font("Arial",15));
        grid.add(firstRadio,0,4);

        RadioButton secondRadio = new RadioButton("My second Radio!");
        secondRadio.setFont(Font.font("Arial",15));
        grid.add(secondRadio,1,4);
        GridPane.setHalignment(secondRadio, HPos.LEFT);


        TextArea firstTextArea = new TextArea("This is the default Text should you decide\n not to type anything");
        firstTextArea.setPrefWidth(400);
        firstTextArea.setPrefHeight(75);
        firstTextArea.setFont(Font.font("Arial",15));
        grid.add(firstTextArea,0,5,2,1);

        TextArea secondTextArea = new TextArea("A second multi-line");
        secondTextArea.setPrefWidth(400);
        secondTextArea.setPrefHeight(75);
        secondTextArea.setFont(Font.font("Arial",15));
        grid.add(secondTextArea,2,5,4,1);

        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().add("Combobox 1");
        comboBox1.getItems().add("Combobox 2");
        comboBox1.getItems().add("Combobox 3");
        comboBox1.getSelectionModel().selectFirst(); //to select first item as default
        comboBox1.setPrefWidth(150);
        comboBox1.setStyle("-fx-font: 15px \"Arial\";");
        grid.add(comboBox1,0,6,2,1);

        Slider horizontalSlide = new Slider(0,100,85);
        horizontalSlide.setShowTickLabels(true);
        horizontalSlide.setShowTickMarks(true);
        horizontalSlide.setSnapToTicks(true);
        horizontalSlide.setMajorTickUnit(5);
        horizontalSlide.setMinorTickCount(10);
        grid.add(horizontalSlide,2,6,4,1);

        ListView<String> listBox = new ListView<String>();
        listBox.setPrefHeight(75);
        ObservableList<String> items = FXCollections.observableArrayList (
                "Listbox1", "Listbox2", "Listbox3", "Listbox4", "Listbox5", "Listbox6");
        listBox.setItems(items);
        grid.add(listBox,0,7,2,1);

        Slider verticalSlider1 = new Slider(0,100,25);
        verticalSlider1.setPrefHeight(75);
        GridPane.setHalignment(verticalSlider1, HPos.LEFT);
        verticalSlider1.setOrientation(Orientation.VERTICAL);
        verticalSlider1.setShowTickLabels(true);
        verticalSlider1.setShowTickMarks(true);
        verticalSlider1.setSnapToTicks(true);
        verticalSlider1.setMajorTickUnit(5);
        verticalSlider1.setMinorTickCount(10);
        grid.add(verticalSlider1,2,7);

        Slider verticalSlider2 = new Slider(0,100,75);
        verticalSlider2.setPrefHeight(75);
        GridPane.setHalignment(verticalSlider2, HPos.CENTER);
        verticalSlider2.setOrientation(Orientation.VERTICAL);
        verticalSlider2.setShowTickLabels(true);
        verticalSlider2.setShowTickMarks(true);
        verticalSlider2.setSnapToTicks(true);
        verticalSlider2.setMajorTickUnit(5);
        verticalSlider2.setMinorTickCount(10);
        grid.add(verticalSlider2,3,7);

        Slider verticalSlider3 = new Slider(0,100,10);
        verticalSlider3.setPrefHeight(75);
        GridPane.setHalignment(verticalSlider3, HPos.RIGHT);
        verticalSlider3.setOrientation(Orientation.VERTICAL);
        verticalSlider3.setShowTickLabels(true);
        verticalSlider3.setShowTickMarks(true);
        verticalSlider3.setSnapToTicks(true);
        verticalSlider3.setMajorTickUnit(5);
        verticalSlider3.setMinorTickCount(10);
        grid.add(verticalSlider3,4,7);

        ObservableList<String> spinList1 = FXCollections.observableArrayList(//
                "Spin Box 3","Spin Box 2", "Spin Box 1");
        ObservableList<String> spinList2 = FXCollections.observableArrayList(//
                "Spin Box 3","Spin Box 2", "Spin Box 1");
        ObservableList<String> spinList3 = FXCollections.observableArrayList(//
                "Spin Box 3","Spin Box 2", "Spin Box 1");
        SpinnerValueFactory<String> valueFactory1 = //
                new SpinnerValueFactory.ListSpinnerValueFactory<String>(spinList1);
        SpinnerValueFactory<String> valueFactory2 = //
                new SpinnerValueFactory.ListSpinnerValueFactory<String>(spinList2);
        SpinnerValueFactory<String> valueFactory3 = //
                new SpinnerValueFactory.ListSpinnerValueFactory<String>(spinList3);
        valueFactory1.setValue("Spin Box 1");
        valueFactory2.setValue("Spin Box 2");
        valueFactory3.setValue("Spin Box 3");
        Spinner <String> spinBox1 = new Spinner<>();
        Spinner <String> spinBox2 = new Spinner<>();
        Spinner <String> spinBox3 = new Spinner<>();
        spinBox1.setValueFactory(valueFactory1);
        spinBox2.setValueFactory(valueFactory2);
        spinBox3.setValueFactory(valueFactory3);
        grid.add(spinBox1,5,7,2,1);
        GridPane.setValignment(spinBox1, VPos.TOP);
        GridPane.setHalignment(spinBox1, HPos.CENTER);
        grid.add(spinBox2,5,7,2,1);
        GridPane.setValignment(spinBox2, VPos.CENTER);
        GridPane.setHalignment(spinBox2, HPos.CENTER);
        grid.add(spinBox3,5,7,2,1);
        GridPane.setValignment(spinBox3, VPos.BOTTOM);
        GridPane.setHalignment(spinBox3, HPos.CENTER);

        Line line = new Line(0, 500, 800, 500);
        grid.add(line,0,9,6,1);

        Text chooseFolderText = new Text("Choose A Folder");
        chooseFolderText.setFont(Font.font("Arial",20));
        grid.add(chooseFolderText,0,10);

        Text yourFolderText = new Text("Your Folder");
        GridPane.setHalignment(yourFolderText, HPos.RIGHT);
        yourFolderText.setFont(Font.font("Arial",20));
        grid.add(yourFolderText,0,11);

        TextField folderText = new TextField();
        folderText.setFont(Font.font("Arial",20));
        grid.add(folderText,1,11);

        Button browseButton = new Button("Browse");
        browseButton.setPrefHeight(35);
        browseButton.setPrefWidth(70);
        grid.add(browseButton,2,11,2,1);


        Button submitButton = new Button("Submit");
        GridPane.setHalignment(submitButton, HPos.RIGHT);
        submitButton.setPrefHeight(35);
        submitButton.setPrefWidth(70);
        grid.add(submitButton,1,12);

        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefHeight(35);
        cancelButton.setPrefWidth(70);
        grid.add(cancelButton,2,12);
        /*
        // Stack
        StackPane stack = new StackPane();
        stack.getChildren().add(submitButton);
        stack.getChildren().add(cancelButton);

        submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            // Anonymous Inner Class
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Submitted");
            }
        });
        cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> {System.out.println("Cancel");}); // Lambda Expression

        // pane.getChildren().add(new Text("Here is some text.... and a place to enter text"));
        // pane.getChildren().add(new TextField("This is my text"));
        */




        Scene scene = new Scene(grid, 850,500 );
        primaryStage.setTitle("Everything bagel"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

