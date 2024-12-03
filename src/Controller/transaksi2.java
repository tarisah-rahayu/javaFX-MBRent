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

/**
 *
 * @author asus
 */
public class transaksi2 implements Initializable {

    
    @FXML
    private TableColumn<ModelAdminTransaksi, String> end_time;

    @FXML
    private TableColumn<ModelAdminTransaksi, Integer> id_pelanggan;

    @FXML
    private TableColumn<ModelAdminTransaksi, Integer> id_produk;

    @FXML
    private TableColumn<ModelAdminTransaksi, Integer> id_transaksi;

    @FXML
    private TableColumn<ModelAdminTransaksi, String> order_date;

    @FXML
    private TableColumn<ModelAdminTransaksi, String> start_time;

    @FXML
    private TableView<ModelAdminTransaksi> tabeltransaksi;

 
    ObservableList<ModelAdminTransaksi> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column();
        loadData();
    }
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
            primaryStage.setTitle("Halaman Data Produk");
           
        //}catch(IOException e){
            //e.printStackTrace();
        //}
    }
    private void column() {
        id_transaksi.setCellValueFactory(new PropertyValueFactory<>("id_transaksi"));
        id_produk.setCellValueFactory(new PropertyValueFactory<>("id_produk"));
        id_pelanggan.setCellValueFactory(new PropertyValueFactory<>("id_pelanggan"));
        order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        start_time.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        end_time.setCellValueFactory(new PropertyValueFactory<>("end_time"));
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
                        st.getString("id_produk"),
                        st.getString("id_pelanggan"),
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
    
    @FXML
    void refreshDataAdmin(ActionEvent event) {
        loadData();
    }
    
    /*@FXML
    public void menuDashboard(ActionEvent d)throws IOException{
        dataPesanan.getScene().getWindow().hide();
        dataPesanan2.getScene().getWindow().hide();
        
        Stage dashboard = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminDashboard.fxml"));
        Scene scene = new Scene(root);
        dashboard.setScene(scene);
        dashboard.show();
        dashboard.setResizable(false);
    }
    
    @FXML
    public void menuPelanggan(ActionEvent d)throws IOException{
        dataPesanan.getScene().getWindow().hide();
        dataPesanan2.getScene().getWindow().hide();
        
        Stage pelanggan = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminDataPelanggan.fxml"));
        Scene scene = new Scene(root);
        pelanggan.setScene(scene);
        pelanggan.show();
        pelanggan.setResizable(false);
    }
    
    @FXML
    void searchAction(ActionEvent event) {
        oblist.clear();

        try {
            java.sql.Connection conn = (Connection) Config.configDB();
            ResultSet st = conn.createStatement().executeQuery("SELECT * FROM  where nama_kelas = '" + kelasText.getText()+"'");
            int no = 1;
            while (st.next()) {
                oblist.add(new ModelKelas(
                        Integer.toString(no++),
                        st.getString("id_kelas"),
                        st.getString("nama_kelas")
                        
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Ada masalah, silahkan coba kembali");
            ex.printStackTrace();
        }
        tabelPelanggan.setItems(oblist);
    }
    
    @FXML
    private void hapusDataKelas(ActionEvent event) {
        ModelAdminPelanggan selectedForDelete = tableKelas.getSelectionModel().getSelectedItem();
        if (selectedForDelete == null) {
            System.out.println("Tidak ada data yang dipilih");
            return;
        }
        //Alert alert = new Alert(Alert.AlertType.WARNING);
        /*alert.setTitle("Deleting kelas");
        alert.setContentText("Are you Sure want to Delete User " + selectedForDelete.getNama_kelas()+ " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            try {
                System.out.println("Menghapus kelas dengan nama "+selectedForDelete.getNama_kelas());
                java.sql.Connection conn = (Connection)Config.configDB();
                int st = conn.createStatement().executeUpdate("DELETE FROM kelas WHERE nama_kelas = '"+selectedForDelete.getNama_kelas()+"'");
                if(st == 1){
                    System.out.println("Data Berhasil dihapus");
                    oblist.remove(selectedForDelete);
                    loadData();
                }else{
                    System.out.println("Data gagal dihapus");
                }
            } catch (SQLException ex) {
                System.out.println("Ada masalah, silahkan coba kembali");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Batal Menghapus data");
        }
    }
    @FXML
    void editDataKelas(ActionEvent event) {
        try{
            ModelKelas selectedForEdit = tableKelas.getSelectionModel().getSelectedItem();
            id_kelas_data    = selectedForEdit.getId_kelas();
            nama_kelas_data    = selectedForEdit.getNama_kelas();
           
            
            KelasData.id_kelas_edit       = id_kelas_data;
            KelasData.kelas_edit          = nama_kelas_data;
            
            FXMLLoader loader = new FXMLLoader(); //.class artinya sebuah class untuk memanggil resource yang akan ditampilkan. (ekstensi beruupa class)

            loader.setLocation(getClass().getResource("../view/editKelas.fxml"));

            AnchorPane root = (AnchorPane) loader.load();
            Stage stage = new Stage();
            
            stage.setTitle("Aplikasi JavaFX Inventaris Lab");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.runLater(() -> {
                        System.out.println("Application Closed by click to Close Button(X)");
                        loadData();
                        KelasData.id_kelas_edit       = null;
                        KelasData.kelas_edit     = null;
                       
                    });
                }
            });
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void insertDataKelas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(); //.class artinya sebuah class untuk memanggil resource yang akan ditampilkan. (ekstensi beruupa class)

            loader.setLocation(getClass().getResource("../view/addKelas.fxml"));

            AnchorPane root = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Aplikasi Smart PCR");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnHiding(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.runLater(() -> {
                        System.out.println("Berhasil, Satu Kelas telah ditambahkan!");
                        loadData();
                    });
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
