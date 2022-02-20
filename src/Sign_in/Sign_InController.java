/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sign_in;

import Controller.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.sql.ConnectionEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author El-Mancy
 */
public class Sign_InController implements Initializable {
    
    // Database connection
    Connection connection;
    Statement statement;

    @FXML
    private Button backBtn;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passField;
    @FXML
    private Button loginBtn;
    @FXML
    private DatePicker dateField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handelButtonAction(ActionEvent event) throws IOException, SQLException {
        if (event.getSource() == backBtn) {
            Parent root = FXMLLoader.load(getClass().getResource("/registration/FXMLDocument.fxml"));
            Stage window = (Stage) backBtn.getScene().getWindow();
            window.setScene(new Scene(root));
        }
        
        if(event.getSource()== loginBtn){
            insertUser();
            Parent root = FXMLLoader.load(getClass().getResource("/Sign_Up/Sign_Up.fxml"));
            Stage window = (Stage) loginBtn.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }
    
    
    public void insertUser() throws SQLException{
        try{
        statement =DatabaseConnection.getConnection().createStatement();
        String sql = "insert into Users (Email,Pass,Time) Values ('"+usernameField.getText()+"' ,'"+passField.getText()+"','"+dateField.getValue()+"') ";
            JOptionPane.showMessageDialog(null, "Done");
        statement.execute(sql);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

}
