/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidur Rahman Akash
 */
public class IssuedServiceController implements Initializable {
    
    Parent root;
    Scene scene;
    Stage stage;
    
    ObservableList<ModelClass3> oblist =FXCollections.observableArrayList();
    
    @FXML
    private TableView<ModelClass3> issuedservicetable;
    @FXML
    private Button issueddelete;
    @FXML
    private Button issuedreload;
    @FXML
    private TableColumn<ModelClass3, String> isid;
    @FXML
    private TableColumn<ModelClass3, String> isname;
    @FXML
    private TableColumn<ModelClass3, String> isiservice;
    @FXML
    private TableColumn<ModelClass3, String> isrservice;
    @FXML
    private Button back;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void issueddelete(MouseEvent event) {
    }

    @FXML
    private void issuedreload(MouseEvent event) {
    }

    @FXML
    private void Handleback(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/adminservices.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("testrt/adminservices.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
