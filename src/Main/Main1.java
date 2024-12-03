package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class Main1 extends Application {

    private static Stage primaryStage;
    private static AnchorPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MB-Rent");

        showMainUserView();

    }

    /*private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/loginPeserta.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    
    public void showMainUserView(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main1.class.getResource("/View/onboarding1.fxml"));
            root = (AnchorPane) loader.load();
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            
           
            
            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}