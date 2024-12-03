package Controller;

/*import static Controller.login.email;
import static Controller.login.id_pelanggan;
import static Controller.login.password;
import static Controller.login.username;*/
import Main.Main1;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.DBUtil;

public class signup implements Initializable {

    
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
    public void initialize(URL url, ResourceBundle rb) {
        javafx.scene.media.AudioClip buzzer = new javafx.scene.media.AudioClip(getClass().getResource("/Audio/welcome.mp3").toExternalForm());
        buzzer.setVolume(0.6);
        buzzer.play();
        loading.setVisible(false);
    }

    @FXML
    private void showkatalog(ActionEvent event) throws IOException {
   try{
            String email_val = email1.getText();
            String username_val = user.getText();
                String password_val = pass.getText();
               
                System.out.println("Username : "+username_val + "+\nEmail : " +email_val+ "\nPassword : " + password_val);
                
                if (password_val!=null) {
                String sql = "INSERT INTO pelanggan VALUES (null, '" + username_val + "', '" + email_val + "', '" + password_val + "')";
                java.sql.Connection conn = (Connection) DBUtil.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();

                System.out.println("=======Berhasil insert, Silahkan Login=========");
                user.setText(null);
                pass.setText(null);
              
                
                }
        } catch(Exception ev){
            System.out.println("Gagal insert : " + ev.getMessage());
        }
                

       
    }
    
    @FXML
    public void signUp(ActionEvent e1)throws IOException{
        signup.getScene().getWindow().hide();
        
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.show();
        login.setResizable(false);
    }
}