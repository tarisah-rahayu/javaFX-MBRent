package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.DBUtil;

public class signUp1 implements Initializable{

    @FXML
    private TextField email1;

    @FXML
    private ImageView loading;

    @FXML
    private PasswordField pass;

    @FXML
    private Button signup;

    @FXML
    private TextField user;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        user.setStyle("-fx-text-inner-color: #000000");
        pass.setStyle("-fx-text-inner-color: #000000");
        
        /*javafx.scene.media.AudioClip buzzer = new javafx.scene.media.AudioClip(getClass().getResource("/audio/signup.mp3").toExternalForm());
        buzzer.setVolume(0.6);
        buzzer.play();*/
    }
    
    @FXML
    public void signUp(ActionEvent ae1){
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(e ->{
            //System.out.print("SignUp Successfully");
            try{
            String username_val = user.getText();
                String email_val = email1.getText();
                String password_val = pass.getText();

                System.out.println("Username : "+username_val + "\nEmail : " + email_val + "\nPassword : " + password_val);
                
                if (password_val!=null) {
                String sql = "INSERT INTO pelanggan VALUES (null, '" + username_val + "', '" + email_val + "', '" + password_val + "')";
                java.sql.Connection conn = (Connection) DBUtil.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();

                Stage home = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
                        
                        Scene scene = new Scene(root);
                        home.setScene(scene);
                        home.show();
                        home.setResizable(false);
                        
                System.out.println("=======Berhasil insert, Silahkan Login=========");
                user.setText(null);
                email1.setText(null);
                pass.setText(null);
                
                }
        } catch(Exception ev){
            System.out.println("Gagal insert : " + ev.getMessage());
        }
                

        });
        pt.play();
    }
}
    
    /*@FXML
    public void loginAction(ActionEvent ae2)throws IOException{
        signup.getScene().getWindow().hide();
        
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/login1 (1).fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.show();
        login.setResizable(false);
    }*/
    

