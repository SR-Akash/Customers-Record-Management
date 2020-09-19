package testrt;

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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidur Rahman Akash
 */
public class UserservicesController implements Initializable {

    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private Button txtFnF;
    @FXML
    private Button call;
    @FXML
    private Button network;
    @FXML
    private Button minit;
    @FXML
    private Button internet;
    @FXML
    private Button sms;
    @FXML
    private Button CallDrop;
    @FXML
    private Button NewCon;
    @FXML
    private Button Emergency;
    @FXML
    private Button back;
    @FXML
    private AnchorPane logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setTEXT(String username, String Password) {
        this.username.setText(username);
        this.pass.setText(Password);

    }

    @FXML
    private void HamdleFnfbtn(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "Go to your Messeage option & Type fnf and send it to 6969");

        String test = txtFnF.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + txtFnF.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Please Insert Valid Data");
        }

    }

    @FXML
    private void Handlecall(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "To know your Call rate please dial *121*3#");

        String test = call.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + call.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }
    }

    @FXML
    private void Handlenetwork(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "Go to your sim card setting & Restart your sim");

        String test = network.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + network.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }
    }

    @FXML
    private void Handleminit(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "Please dail *121#");

        String test = minit.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + minit.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }
    }

    @FXML
    private void Handleinternet(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "Please dail *121*5#");
        String test = internet.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + internet.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }
    }

    @FXML
    private void Handlesms(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "Please dail *121*9#");
        String test = sms.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + sms.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }
    }

    @FXML
    private void HandleCallDrop(ActionEvent event) throws SQLException {
        Testrt.ShowInformationAlertBox("For this Service : " + "\n" + "Please keep patience, your call drop minute will be added to your further call");
        String test = CallDrop.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + CallDrop.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }

    }

    @FXML
    private void HandleNewCon(ActionEvent event) throws SQLException {
       Testrt.ShowInformationAlertBox("For this Service : "+"\n"+"Please go to your message option & type NEWCON send it to 6969");

        String test = NewCon.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + NewCon.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }

    }

    @FXML
    private void HandleEmergency(ActionEvent event) throws SQLException {
       Testrt.ShowInformationAlertBox("For this Service : "+"\n"+"For Emergency Please Call us - 01794591853");
        String test = Emergency.getText();
        System.err.println(test);
        DBConnection connectionclass = new DBConnection();
        Connection connection = connectionclass.getConnection();

        String sql = "INSERT INTO final_service VALUES('" + username.getText() + "','" + Emergency.getText() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("Your Service Has Been Added");

        } catch (Exception e) {
            System.err.println("Insert Valid Data");
        }

    }

    @FXML
    private void Handleback(MouseEvent event) throws IOException {

        stage = (Stage) back.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("home.fxml"));

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private void Handlelogout(MouseEvent event) {
    }

}
