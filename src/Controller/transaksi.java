package Controller;

import util.DBUtil;
import model.ModelAdminTransaksi;
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

/**
 *
 * @author asus
 */
public class transaksi implements Initializable {

    /*public static String id_customer_data;
    public static String email_customer_data;
    public static String password_data;
    public static String gender_data;*/
    
     @FXML
    private TableColumn<ModelAdminTransaksi, String> endtime;

    @FXML
    private TableColumn<ModelAdminTransaksi, Integer> idpelanggan;

    @FXML
    private TableColumn<ModelAdminTransaksi, Integer> idproduk;

    @FXML
    private TableColumn<ModelAdminTransaksi, Integer> idtransaksi;

    @FXML
    private TableColumn<ModelAdminTransaksi, String> orderdate;

    @FXML
    private TableColumn<ModelAdminTransaksi, String> starttime;

    @FXML
    private TableView<ModelAdminTransaksi> tabeltransaksi;

    ObservableList<ModelAdminTransaksi> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column();
        loadData();
    }
    
        private void column() {
        idpelanggan.setCellValueFactory(new PropertyValueFactory<>("id_pelanggan"));
        idtransaksi.setCellValueFactory(new PropertyValueFactory<>("id_transaksi"));
        idproduk.setCellValueFactory(new PropertyValueFactory<>("id_produk"));
        orderdate.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        starttime.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        endtime.setCellValueFactory(new PropertyValueFactory<>("end_time"));
        
    }
         public void loadData() {
        oblist.clear();

        try {
            java.sql.Connection conn = (Connection) DBUtil.configDB();
            ResultSet st = conn.createStatement().executeQuery("SELECT * FROM transaksi");
            //int no = 1;
            while (st.next()) {
                oblist.add(new ModelAdminTransaksi(
                        //Integer.toString(no++),
                        st.getString("id_transaksi"),
                        st.getString("id_pelanggan"),
                        st.getString("id_produk"),
                        st.getString("order_date"),
                        st.getString("start_time"),
                        st.getString("end_time")
              
                        
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Ada masalah, silahkan coba kembali");
            ex.printStackTrace();
        }
        tabeltransaksi.setItems(oblist);
    }
}