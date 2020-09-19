
package testrt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidur Rahman Akash
 */
public class UserloginController implements Initializable {
    
    
    @FXML
    private Label error;
    @FXML
    private TextField ULogin;
    @FXML
    private PasswordField UPass;
    @FXML
    private Button Login;
    @FXML
    private Button back;
    private Connection connection;
    private PreparedStatement preparedStatement;
    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private Button Clear;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Login(MouseEvent event) throws IOException, SQLException {
        
        String set_name = ULogin.getText();
        String set_pass = UPass.getText();
        Node node = (Node) event.getSource();
        Stage st = (Stage) node.getScene().getWindow();
        st.close();
        if (event.getSource() == Login) {
            if (UserlogIn().equals("Success")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("userservices.fxml"));
                try {
                    loader.load();
                } 
                catch (Exception e) {
                    System.err.println(e);
                }
        
        UserservicesController display=loader.getController();
        display.setTEXT(set_name, set_pass);
        Parent p=loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
        
            }
        }
    }

   

     public String UserlogIn() {

        String user = ULogin.getText();
        String password = UPass.getText();

        String sql = "SELECT * FROM userreg Where Username=? and Pass= ?";
        try {
            DBConnection connectionclass=new DBConnection();
            Connection connection=connectionclass.getConnection();
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, password);
            ResultSet resultSet = st.executeQuery();
            if (!resultSet.next()) {
                Testrt.ShowInformationAlertBox("Wrong User Name or Password"+"\n"+"Please Try Again");
                return "Error";

            } 
            else {
                System.out.println("Successfull Login");
                return "Success";
            }

        } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        stage = (Stage)back.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("home.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
    }

    @FXML
    private void Clear(MouseEvent event) {
        ULogin.setText(null);
        UPass.setText(null);
    }
    
}
