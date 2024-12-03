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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ob{

    private Stage primaryStage;
    private Scene scene;
    private Parent root;

    @FXML
    private void showLogin(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/login.fxml"));
            root = loader.load();
            
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Halama Login");
           
        //}catch(IOException e){
            //e.printStackTrace();
        //}
    }
    @FXML
    private void showSignUp(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/signup2.fxml"));
            root = loader.load();
            
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Halaman Sign UP");
           
        //}catch(IOException e){
            //e.printStackTrace();
        //}
    }
     
    
}
