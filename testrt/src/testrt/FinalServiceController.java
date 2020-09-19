/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidur Rahman Akash
 */
public class FinalServiceController implements Initializable {

    Parent root;
    Scene scene;
    Stage stage;

    ObservableList<ModelClass2> oblist =FXCollections.observableArrayList();
    @FXML
    private TextField servicetitle;
    @FXML
    private Button add;
    @FXML
    private Button serviceupdate;
    @FXML
    private Button servicedelete;
    @FXML
    private Button reload;
    

    @FXML
    private Button back;
    @FXML
    private TableView<ModelClass3> ourtable;
    @FXML
    private TableColumn<ModelClass3, String> Service;

   ObservableList<ModelClass3> ok =FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            Connection conn;
        try {
            conn = DBConnection.getConnection();
        
            String sql = "select Service from ourservice";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {

                ok.add(new ModelClass3(rs.getString("Service")));

            }
        }
        catch (SQLException ex) {
           
        }
        Service.setCellValueFactory(new PropertyValueFactory<>("Service"));

        ourtable.setItems(ok);

    }    
    

    @FXML
    private void add(MouseEvent event) throws SQLException {


        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO ourservice VALUES ('"+servicetitle.getText()+"')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            Testrt.ShowInformationAlertBox("New Data Inserted");
            servicetitle.clear();
   
        } catch (Exception e) {
            Testrt.ShowInformationAlertBox("Insert Valid Data");
        }
    }
    

    @FXML
    private void serviceupdate(MouseEvent event) {
    }

    @FXML
    private void servicedelete(MouseEvent event) {
    }

    @FXML
    private void servicereload(MouseEvent event) {
    }

    @FXML
    private void Handleback(MouseEvent event) throws IOException {
        
        stage = (Stage) back.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("adminservices.fxml"));

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
        
    }
    
}
