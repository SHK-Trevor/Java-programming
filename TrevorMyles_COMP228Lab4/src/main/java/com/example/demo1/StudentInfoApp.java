package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

public class StudentInfoApp extends Application {

    private TextField nameField, addressField, cityField, provinceField, postalCodeField, phoneField, emailField;
    private RadioButton csMajorRadio, businessMajorRadio;
    private ComboBox<String> courseComboBox;
    private ListView<String> courseListView;
    private Set<String> selectedCourses = new HashSet<>();
    private CheckBox sportsCheckBox, musicCheckBox, volunteeringCheckBox;
    private TextArea displayArea;

    @Override
    public void start(Stage primaryStage) {
        // Create input fields
        nameField = new TextField();
        addressField = new TextField();
        cityField = new TextField();
        provinceField = new TextField();
        postalCodeField = new TextField();
        phoneField = new TextField();
        emailField = new TextField();

        // Layout for input fields
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(10));

        inputGrid.add(new Label("Full Name:"), 0, 0);
        inputGrid.add(nameField, 1, 0);
        inputGrid.add(new Label("Address:"), 0, 1);
        inputGrid.add(addressField, 1, 1);
        inputGrid.add(new Label("City:"), 0, 2);
        inputGrid.add(cityField, 1, 2);
        inputGrid.add(new Label("Province:"), 0, 3);
        inputGrid.add(provinceField, 1, 3);
        inputGrid.add(new Label("Postal Code:"), 0, 4);
        inputGrid.add(postalCodeField, 1, 4);
        inputGrid.add(new Label("Phone Number:"), 0, 5);
        inputGrid.add(phoneField, 1, 5);
        inputGrid.add(new Label("Email:"), 0, 6);
        inputGrid.add(emailField, 1, 6);

        // Radio buttons for major selection
        ToggleGroup majorGroup = new ToggleGroup();
        csMajorRadio = new RadioButton("Computer Science");
        csMajorRadio.setToggleGroup(majorGroup);
        businessMajorRadio = new RadioButton("Business");
        businessMajorRadio.setToggleGroup(majorGroup);

        HBox majorBox = new HBox(10, new Label("Major:"), csMajorRadio, businessMajorRadio);

        // ComboBox for courses
        courseComboBox = new ComboBox<>();
        courseComboBox.setDisable(true); // Initially disabled

        // Populate courses based on major selection
        csMajorRadio.setOnAction(e -> {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Java Programming", "Data Structures", "Algorithms", "Operating Systems");
            courseComboBox.setDisable(false);
        });

        businessMajorRadio.setOnAction(e -> {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Accounting", "Marketing", "Management", "Economics");
            courseComboBox.setDisable(false);
        });

        // ListView for selected courses
        courseListView = new ListView<>();
        courseComboBox.setOnAction(e -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !selectedCourses.contains(selectedCourse)) {
                selectedCourses.add(selectedCourse);
                courseListView.getItems().add(selectedCourse);
            }
        });

        // Checkboxes for additional information
        sportsCheckBox = new CheckBox("Sports");
        musicCheckBox = new CheckBox("Music");
        volunteeringCheckBox = new CheckBox("Volunteering");
        HBox activitiesBox = new HBox(10, sportsCheckBox, musicCheckBox, volunteeringCheckBox);

        // Text area to display student information
        displayArea = new TextArea();
        displayArea.setPrefHeight(200);

        // Button to display information
        Button displayButton = new Button("Display Information");
        displayButton.setOnAction(e -> displayStudentInfo());

        // Layout organization
        VBox leftPanel = new VBox(10, inputGrid, majorBox, new Label("Courses:"), courseComboBox, courseListView, activitiesBox, displayButton);
        leftPanel.setPadding(new Insets(10));
        VBox rightPanel = new VBox(10, new Label("Student Information:"), displayArea);
        rightPanel.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setLeft(leftPanel);
        root.setCenter(rightPanel);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Information Form");
        primaryStage.show();
    }

    // Method to display student information
    private void displayStudentInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Full Name: ").append(nameField.getText()).append("\n")
                .append("Address: ").append(addressField.getText()).append("\n")
                .append("City: ").append(cityField.getText()).append("\n")
                .append("Province: ").append(provinceField.getText()).append("\n")
                .append("Postal Code: ").append(postalCodeField.getText()).append("\n")
                .append("Phone Number: ").append(phoneField.getText()).append("\n")
                .append("Email: ").append(emailField.getText()).append("\n")
                .append("Major: ").append(csMajorRadio.isSelected() ? "Computer Science" : businessMajorRadio.isSelected() ? "Business" : "").append("\n")
                .append("Courses: ").append(String.join(", ", selectedCourses)).append("\n")
                .append("Activities: ");

        if (sportsCheckBox.isSelected()) info.append("Sports ");
        if (musicCheckBox.isSelected()) info.append("Music ");
        if (volunteeringCheckBox.isSelected()) info.append("Volunteering ");

        displayArea.setText(info.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}