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

public class Katalogg implements Initializable {

    private Stage primaryStage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private ImageView loading;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        javafx.scene.media.AudioClip buzzer = new javafx.scene.media.AudioClip(getClass().getResource("/Audio/welcome.mp3").toExternalForm());
        buzzer.setVolume(0.6);
        buzzer.play();
        loading = new ImageView();
        loading.setVisible(false);
    }

    @FXML
    private void showkatalog(ActionEvent event) throws IOException {
       //try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/katalog.fxml"));
            root = loader.load();
            
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Halamannn katalog");
           
        //}catch(IOException e){
            //e.printStackTrace();
        //}
    }
    
    
}
