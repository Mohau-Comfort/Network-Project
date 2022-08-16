import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author Mahlakwane MC
 * @StudentNumber 217044163
 *
 */
public class Main extends Application{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    launch(args);
	}
 
	@Override
	public void start(Stage myMain) throws Exception {
		
	
	    AppUI App = new AppUI();
		Scene sc = new Scene(App);

		myMain.setTitle("iPhotoEditorv0.1");
		myMain.setScene(sc);
		myMain.show();
	}

}
