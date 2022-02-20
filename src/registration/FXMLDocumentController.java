/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author El-Mancy
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button signinBtn;
    @FXML
    private Button signupBtn;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handelButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == signinBtn){
            Parent root = FXMLLoader.load(getClass().getResource("/Sign_in/Sign_In.fxml"));
            Stage window = (Stage) signinBtn.getScene().getWindow();
            window.setScene(new Scene(root));
            
        }
        
        if(event.getSource() == signupBtn){
            Parent root = FXMLLoader.load(getClass().getResource("/Sign_Up/Sign_Up.fxml"));
            Stage window = (Stage) signupBtn.getScene().getWindow();
            window.setScene(new Scene(root));
            
        }
    }
    
}
