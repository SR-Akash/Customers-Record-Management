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
public class AdminservicesController implements Initializable {

    Parent root;
    Stage stage;
    Scene scene;
    Connection connection;
    
    private PreparedStatement preparedStatement;
    ObservableList<modelclass1> oblist = FXCollections.observableArrayList();
    
    ResultSet rs ;
    @FXML
    private TableView<modelclass1> userdetailstable;
    @FXML
    private Button delete;
    @FXML
    private Button userreload;
    @FXML
    private TableColumn<modelclass1, String> u1;
    @FXML
    private TableColumn<modelclass1, String> u2;
    @FXML
    private TableColumn<modelclass1, String> u3;
    @FXML
    private TableColumn<modelclass1, String> u4;
    @FXML
    private TableColumn<modelclass1, String> u5;
    @FXML
    private TableColumn<modelclass1, String> u6;
    @FXML
    private TableColumn<modelclass1, String> u7;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField t7;
    @FXML
    private Button fsservice;
    @FXML
    private Button isservice;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "select * from userreg";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {

                oblist.add(new modelclass1(rs.getString("id"), rs.getString("Username"), rs.getString("Pass"), rs.getString("Phone"),rs.getString("Email"),rs.getString("Address"),rs.getString("Gender")
                ));
            }

        } catch (SQLException ex) {
            System.out.print(ex);
        }
        u1.setCellValueFactory(new PropertyValueFactory<>("id"));
        u2.setCellValueFactory(new PropertyValueFactory<>("Username"));
        u3.setCellValueFactory(new PropertyValueFactory<>("Pass"));
        u4.setCellValueFactory(new PropertyValueFactory<>("Phone"));
         u5.setCellValueFactory(new PropertyValueFactory<>("Email"));
        u6.setCellValueFactory(new PropertyValueFactory<>("Address"));
        u7.setCellValueFactory(new PropertyValueFactory<>("Gender"));

        userdetailstable.setItems(oblist);
    }    
    
     private boolean validatefields() {

        if (t1.getText().isEmpty() | t2.getText().isEmpty() | t3.getText().isEmpty()|t4.getText().isEmpty() | t5.getText().isEmpty() | t6.getText().isEmpty()| t7.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Not Selected");
            alert.setHeaderText(null);
            alert.setContentText("No user is selected");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    private void update(MouseEvent event) {
        
        
        if (validatefields()) {

            try {
                connection = DBConnection.getConnection();

                String sql = "Update  customer  set  Username=?, Pass=?, Phone=?, Email=?, Address=?, Gender=? where id ='" + t1.getText() + "'";

                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, t2.getText());
                preparedStatement.setString(2, t3.getText());
                preparedStatement.setString(3, t4.getText());
                preparedStatement.setString(3, t5.getText());
                preparedStatement.setString(3, t6.getText());

                preparedStatement.execute();

                 Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Successfull!");
                alert.setHeaderText(null);
                alert.setContentText("User Has been Updated Successfully");
                alert.showAndWait();

                preparedStatement.close();
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        t6.clear();
        t7.clear();

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else {

        }
        
    }

    @FXML
    private void delete(MouseEvent event) {
         if (validatefields() ) {

            try {

                modelclass1 user = (modelclass1) userdetailstable.getSelectionModel().getSelectedItem();
                connection = DBConnection.getConnection();
                String query = "DELETE  from userreg where id=?";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, user.getId());
                preparedStatement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Successful!");
            alert.setHeaderText(null);
            alert.setContentText("User Has Been Deleted Successfully");
            alert.showAndWait();

                preparedStatement.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        t6.clear();
        t7.clear();
        
    }


    @FXML
    private void userreload(MouseEvent event) {
        
        oblist.clear();

        try {

            connection = DBConnection.getConnection();

            String query = "select * from userreg";

            preparedStatement = connection.prepareStatement(query);
            
            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                oblist.add(new modelclass1(
                        rs.getString("id"),
                        rs.getString("Username"),
                        rs.getString("Pass"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("Address"),
                        rs.getString("Gender")
                ));

                userdetailstable.setItems(oblist);

            }

        } catch (SQLException e) {
            System.out.print(e);
        }
    }


    @FXML
    private void getuserdata(MouseEvent event) {
        
        try {
            modelclass1 user = (modelclass1) userdetailstable.getSelectionModel().getSelectedItem();

            String query = "select * from userreg where id = ?";
            Connection connection = DBConnection.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getId());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                t1.setText(rs.getString("id"));
                t2.setText(rs.getString("Username"));
                t3.setText(rs.getString("Pass"));
                t4.setText(rs.getString("Phone"));
                t5.setText(rs.getString("Email"));
                t6.setText(rs.getString("Address"));
                t7.setText(rs.getString("Gender"));

            }
            preparedStatement.close();
            rs.close();
        } catch (Exception e) {

            System.out.println(e);
        }
    }

    @FXML
    private void Handlefsservice(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinalService.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("testrt/FinalService.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Handleisservice(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IssuedService.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("testrt/IssuedService.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void handleback(MouseEvent event) throws IOException {
        
        stage = (Stage) back.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("home.fxml"));

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
    
}
