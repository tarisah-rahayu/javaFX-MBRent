package Controller;

import util.DBUtil;
import model.ModelAdminCustomer;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.ModelAdminTransaksi;

public class tabelcust implements Initializable{
    
    @FXML
    private TableColumn<ModelAdminCustomer, String> email;

    @FXML
    private TableColumn<ModelAdminCustomer, String> id_pelanggan;

    @FXML
    private TableColumn<ModelAdminCustomer, String> password;

    @FXML
    private TableView<ModelAdminCustomer> tabelcustomer;

    @FXML
    private TableColumn<ModelAdminCustomer, String> username;

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private void exit(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/dashboard.fxml"));
            root = loader.load();
            
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Halaman Data Customer");
           
        //}catch(IOException e){
            //e.printStackTrace();
        //}
    }
    ObservableList<ModelAdminCustomer> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column();
        loadData();
    }
    
    private void column() {
        id_pelanggan.setCellValueFactory(new PropertyValueFactory<>("id_pelanggan"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    public void loadData() {
        oblist.clear();

        try {
            java.sql.Connection conn = (Connection) DBUtil.configDB();
            ResultSet st = conn.createStatement().executeQuery("SELECT * FROM pelanggan");
            //int no = 1;
            while (st.next()) {
                oblist.add(new ModelAdminCustomer(
                        //Integer.toString(no++),
                        st.getString("id_pelanggan"),
                        st.getString("username"),
                        st.getString("email"),
                        st.getString("password")
                        
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Ada masalah, silahkan coba kembali");
            ex.printStackTrace();
        }
        tabelcustomer.setItems(oblist);
    }
    
    @FXML
    void refreshDataAdmin(ActionEvent event) {
        loadData();
    }
    
     
    
}
