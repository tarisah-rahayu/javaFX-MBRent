package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class onboardingcontroller implements Initializable{

@FXML
    private Button signup;

    @FXML
    private Button login;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        
    }
    
    @FXML
    public void loginAction(ActionEvent e)throws IOException{
        /*PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev ->{
            System.out.print("Login Successfully");
        });
        pt.play();*/
        login.getScene().getWindow().hide();
        
        Stage home = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.show();
        home.setResizable(false);
    }
    
    @FXML
    public void signUp(ActionEvent e1)throws IOException{
        login.getScene().getWindow().hide();
        
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/signUP.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
       
}

}
