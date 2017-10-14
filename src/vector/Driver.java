package vector;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Nick
 */
public class Driver extends Application 
{
    
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Vector Functions");
        try
        {
           Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
           Scene scene = new Scene(root,822,592);
           primaryStage.setResizable(false);
           primaryStage.setScene(scene);
           primaryStage.show();
        }
       
        catch(IOException e)
        {
            e.printStackTrace();
        }   
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
