package com.example.studentmanager.controllers;

import com.example.studentmanager.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, Integer> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> emailColumn;
    @FXML private TableColumn<Student, String> majorColumn;
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField majorField;

    private ObservableList<Student> studentList;

    @FXML
    public void initialize() {
        studentList = FXCollections.observableArrayList();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        studentTable.setItems(studentList);
    }

    @FXML
    public void handleAdd(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String email = emailField.getText();
        String major = majorField.getText();

        Student student = new Student(id, name, email, major);
        studentList.add(student);

        clearFields();
    }

    @FXML
    public void handleUpdate(ActionEvent event) {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            selectedStudent.setId(Integer.parseInt(idField.getText()));
            selectedStudent.setName(nameField.getText());
            selectedStudent.setEmail(emailField.getText());
            selectedStudent.setMajor(majorField.getText());

            studentTable.refresh();
            clearFields();
        }
    }

    @FXML
    public void handleDelete(ActionEvent event) {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
            clearFields();
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        emailField.clear();
        majorField.clear();
    }
}
