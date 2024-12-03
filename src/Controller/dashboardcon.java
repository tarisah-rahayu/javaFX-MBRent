package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class dashboardcon implements Initializable{

    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private LineChart<?, ?> lineChart;

  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       iniLineChart();
       
    }
    
    private void iniLineChart(){
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Senin",17));
        series.getData().add(new XYChart.Data("Selasa", 15));
        series.getData().add(new XYChart.Data("Rabu", 15));
        series.getData().add(new XYChart.Data("Kamis", 15));
        series.getData().add(new XYChart.Data("Jumat", 15));
        series.getData().add(new XYChart.Data("Sabtu", 25));
        series.getData().add(new XYChart.Data("Minggu", 30));
        lineChart.getData().addAll(series);
        series.getNode().setStyle("-fx-stroke: #ffc300");
    }
    
   
    @FXML
    private void showcustomer(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/tabelcust.fxml"));
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
    @FXML
    private void produk(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/tabelproduct.fxml"));
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
    @FXML
    private void transaksi(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/transaksi (1).fxml"));
            root = loader.load();
            
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Halaman Data Transaksi");
           
        //}catch(IOException e){
            //e.printStackTrace();
        //}
    }
    
     
    
}
