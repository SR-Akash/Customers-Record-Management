/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidur Rahman Akash
 */
public class HomeController implements Initializable {
    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private Button Registration;
    private Button Admin;
    @FXML
    private Button UserLogin;
    @FXML
    private Button AdminLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Registration(MouseEvent event) throws IOException {
        stage = (Stage)Registration.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("Reg.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
    }

   

    private void UserLogin(MouseEvent event) throws IOException {
        stage = (Stage)UserLogin.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("Userlogin.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
    }

    @FXML
    private void Admin_Login(MouseEvent event) throws IOException {
        stage = (Stage)AdminLogin.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("Admin.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
    }

    @FXML
    private void User_Login(MouseEvent event) throws IOException {
        stage = (Stage)UserLogin.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("Userlogin.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
    }
    
}
