package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.DBUtil;



public class login implements Initializable{
    
    public static String id_pelanggan_data;
    public static String email_pelanggan_data;
    public static String password_data;
    public static String username_data;
    
    @FXML
    private TextField email1;

    @FXML
    private ImageView loading;

    @FXML
    private Button login;

    @FXML
    private PasswordField pass;
   

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        
        
        email1.setStyle("-fx-text-inner-color: #000000");
        pass.setStyle("-fx-text-inner-color: #000000");
        
        javafx.scene.media.AudioClip buzzer = new javafx.scene.media.AudioClip(getClass().getResource("/Audio/welcome.mp3").toExternalForm());
        buzzer.setVolume(0.6);
        buzzer.play();
        loading.setVisible(false);
    }
    
    
    
    
    
    @FXML
    public void loginAction(ActionEvent e)throws IOException{
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev ->{
            System.out.print("Login Successfully");
            try {
                java.sql.Connection conn = (Connection) DBUtil.configDB();
                ResultSet st = conn.createStatement().executeQuery("SELECT * FROM pelanggan where email = '" + email1.getText() + "'and password ='" + String.valueOf(pass.getText()) + "'");
//                ResultSet st = conn.createStatement().executeQuery("SELECT * FROM admin where username = 'danzai'and password ='123'");

                if (st.next()) {
                    id_pelanggan_data = st.getString("id_pelanggan");
                    email_pelanggan_data = st.getString("email");
                    password_data = st.getString("password");
                    username_data = st.getString("username");

                    /*DataAnggota.id_user = id_user_data;
                    DataAnggota.email = email_data;
                    DataAnggota.password = password_data;
                    DataAnggota.konfirmasi = konfirmasi_data;
                    DataAnggota.nama = nama_data;
                    DataAnggota.nim = nim_data;*/

                    login.getScene().getWindow().hide();

                    if (email_pelanggan_data.equals("nurul@gmail.com")) {
                        Stage home = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/View/kkkk.fxml"));
                        
                        Scene scene = new Scene(root);
                        home.setScene(scene);
                        home.show(); 
                        home.setResizable(false);
                    } else {
                        Stage login = new Stage();
                        FXMLLoader loader = new FXMLLoader(); //.class artinya sebuah class untuk memanggil resource yang akan ditampilkan. (ekstensi beruupa class)

                        loader.setLocation(getClass().getResource("/View/login.fxml"));

                        AnchorPane root = (AnchorPane) loader.load();
                        Scene scene = new Scene(root);
                        login.setScene(scene);
                        login.show();
                        login.setResizable(false);
                    }

                } else {
                    System.out.println("Email atau Password salah");
                }
            } catch (SQLException ex) {
                System.out.println("Ada masalah, silahkan coba kembali");
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        pt.play();
        /*login.getScene().getWindow().hide();
        
        Stage home = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/home2.fxml"));
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.show();
        home.setResizable(false);*/
    }
    
   /* @FXML
    public void signUp(ActionEvent e1)throws IOException{
        login.getScene().getWindow().hide();
        
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/signup.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);*/
    }

