package socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ap extends Application 
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
    	FXMLLoader ld = new FXMLLoader(getClass().getResource("gui.fxml"));
    	Parent root = ld.load();
        primaryStage.setTitle("First Trade");
        primaryStage.setScene(new Scene(root, 882, 555));
		primaryStage.setResizable(false);
        primaryStage.show();
        client cl = ld.getController();
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}
