/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author User
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class katalogcontroller implements Initializable {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

   @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        javafx.scene.media.AudioClip buzzer = new javafx.scene.media.AudioClip(getClass().getResource("/Audio/welcome.mp3").toExternalForm());
        buzzer.setVolume(0.6);
        buzzer.play();
       
    }
    @FXML
      public void showTableOrder(ActionEvent el)throws IOException{
        btn1.getScene().getWindow().hide();
        btn2.getScene().getWindow().hide();
        btn3.getScene().getWindow().hide();
        btn4.getScene().getWindow().hide();
        btn5.getScene().getWindow().hide();
        btn6.getScene().getWindow().hide();
        btn7.getScene().getWindow().hide();
        btn8.getScene().getWindow().hide();
        
        Stage detail = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/order.fxml"));
        Scene scene = new Scene(root);
        detail.setScene(scene);
        detail.show();
        detail.setResizable(false);
    }

}

