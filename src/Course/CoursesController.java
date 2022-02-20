/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course;

import Controller.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author El-Mancy
 */
public class CoursesController implements Initializable {

    @FXML
    private TextField FnField;
    @FXML
    private TextField LnField;
    @FXML
    private ComboBox<String> gradeField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox TimeField;
    @FXML
    private Button submitBtn;
    @FXML
    private TextField phoneField;
    @FXML
    private Button BackBtn;
    @FXML
    private ComboBox<String> c1;
    @FXML
    private ComboBox<String> c6;
    @FXML
    private ComboBox<String> c4;
    @FXML
    private ComboBox<String> c2;
    @FXML
    private ComboBox<String> c3;
    @FXML
    private ComboBox<String> c5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> grade = FXCollections.observableArrayList("1", "2", "3", "4");
        ObservableList<String> time = FXCollections.observableArrayList("9 PM", "11 PM", "1 PM");
//        ObservableList<String> tracks = FXCollections.observableArrayList("MATH 0", "PROGRAMMING 1", "INTRODUCTION", "IS", "DISCRETE", "PHYSICS");
//
//        ObservableList<String> tracks1 = FXCollections.observableArrayList("COMPUTER ORGANIZATION", "MATH 1", "PROGRAMMING 2", "LOGIC", "WEB DEVELOPMENT", "MULTI MEDIA");
//        ObservableList<String> tracks2 = FXCollections.observableArrayList("ARTICIAL INTELLIGENCE", "PROGRAMMING 3", "SOFTWARE ENGINNERING", "DATABASE", "CLOUD COMPUTING", "OPERATION SYSTEM 1");
//        ObservableList<String> tracks3 = FXCollections.observableArrayList("OPERATING SYSTEM 2", "GRAPHICS", "DISTRIBUTED SYSTEMS", "INFORMATION ENGINNERING", "KBS", "LANGUAGE PROCESSING");

        TimeField.setItems(time);
        gradeField.setItems(grade);

    }

    @FXML
    private void handelButtonAction(ActionEvent event) throws SQLException, IOException {

        ObservableList<String> tracks = FXCollections.observableArrayList("MATH 0", "PROGRAMMING 1", "INTRODUCTION", "IS", "DISCRETE", "PHYSICS","COMPUTER ETHICS","HUMAN RIGHTS");
        if (gradeField.getSelectionModel().getSelectedItem() == "1") {

            c1.setItems(tracks);
            c2.setItems(tracks);
            c3.setItems(tracks);
            c4.setItems(tracks);
            c5.setItems(tracks);
            c6.setItems(tracks);
        }

        if (gradeField.getSelectionModel().getSelectedItem() == "2") {
        ObservableList<String> tracks1 = FXCollections.observableArrayList("COMPUTER ORGANIZATION", "MATH 1", "PROGRAMMING 2", "LOGIC", "WEB DEVELOPMENT", "MULTI MEDIA","MANAGMENT","DATA STRUCTURE");

            c1.setItems(tracks1);
            c2.setItems(tracks1);
            c3.setItems(tracks1);
            c4.setItems(tracks1);
            c5.setItems(tracks1);
            c6.setItems(tracks1);
        }
        if (gradeField.getSelectionModel().getSelectedItem() == "3") {
        ObservableList<String> tracks2 = FXCollections.observableArrayList("ARTIFICIAL INTELLIGENCE", "PROGRAMMING 3", "SOFTWARE ENGINNERING", "DATABASE", "CLOUD COMPUTING", "OPERATION SYSTEM 1","SIGNAL","SYSTEM ANALYSIS 2","NETWORK 1");

            c1.setItems(tracks2);
            c2.setItems(tracks2);
            c3.setItems(tracks2);
            c4.setItems(tracks2);
            c5.setItems(tracks2);
            c6.setItems(tracks2);
        }
        if (gradeField.getSelectionModel().getSelectedItem() == "4") {
        ObservableList<String> tracks3 = FXCollections.observableArrayList("OPERATING SYSTEM 2", "GRAPHICS", "DISTRIBUTED SYSTEMS", "INFORMATION ENGINNERING", "KBS", "LANGUAGE PROCESSING","FLUTTER","PYTHON","NETWORK 2");

            c1.setItems(tracks3);
            c2.setItems(tracks3);
            c3.setItems(tracks3);
            c4.setItems(tracks3);
            c5.setItems(tracks3);
            c6.setItems(tracks3);
        }

        if (event.getSource() == submitBtn) {
            insertCourses();
            JOptionPane.showMessageDialog(null, "Thank You For Your Registration");
            Parent root = FXMLLoader.load(getClass().getResource("/Course/Courses.fxml"));
            Stage window = (Stage) BackBtn.getScene().getWindow();
            window.setScene(new Scene(root));

        }
        if (event.getSource() == BackBtn) {
            Parent root = FXMLLoader.load(getClass().getResource("/registration/FXMLDocument.fxml"));
            Stage window = (Stage) BackBtn.getScene().getWindow();
            window.setScene(new Scene(root));
        }

    }

    public void insertCourses() throws SQLException {
        try {
            Statement statement;
            statement = DatabaseConnection.getConnection().createStatement();
            String sql = "insert into courses (First_Name , Last_Name , Email , Phone ,Grade , Time,SUB1,SUB2,SUB3,SUB4,SUB5,SUB6) values ('" + FnField.getText() + "' ,'" + LnField.getText() + "' ,'" + emailField.getText() + "' ,'" + phoneField.getText() + "','" + gradeField.getValue() + "','" + TimeField.getValue() + "', '" + c1.getValue() + "','" + c2.getValue() + "','" + c3.getValue() + "','" + c4.getValue() + "','" + c5.getValue() + "','" + c6.getValue() + "')";
            statement.execute(sql);

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Error");
            System.out.println(ex.toString());
        }
    }

}
