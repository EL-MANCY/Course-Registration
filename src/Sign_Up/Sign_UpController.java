/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sign_Up;

import Controller.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author El-Mancy
 */
public class Sign_UpController implements Initializable {
    
    Statement statement;
    Connection connection;

    @FXML
    private TextField userNameField;
    @FXML
    private TextField passField;
    @FXML
    private Button loginBtn;
    @FXML
    private Button backBtn;
    @FXML
    private ComboBox gradeField1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void handelButtonAction(ActionEvent event) throws SQLException, IOException {
        
        if(event.getSource() == loginBtn){
            checkLogin();
            
        }
         if (event.getSource() == backBtn) {
            Parent root = FXMLLoader.load(getClass().getResource("/registration/FXMLDocument.fxml"));
            Stage window = (Stage) backBtn.getScene().getWindow();
            window.setScene(new Scene(root));
        }
        
    }
    
    public void checkLogin() throws SQLException, IOException{
        
        statement =DatabaseConnection.getConnection().createStatement();
        String sql = "Select * from Users where Email ='"+userNameField.getText()+"' and Pass ='"+passField.getText()+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        
        if(resultSet.next()){
            
            Parent root = FXMLLoader.load(getClass().getResource("/Course/Courses.fxml"));
            Stage window = (Stage) loginBtn.getScene().getWindow();
            window.setScene(new Scene(root));
        }else{
            JOptionPane.showMessageDialog(null, "Not Found");
        }
    }

    @FXML
    private void initialize(ActionEvent event) {
    }
}
  
