import javafx.scene.layout.StackPane;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
/**
 * 
 * @author Mahlakwane MC
 * @StudentNumber 217044163
 *
 */
//This class is the class that will provide the first user interface that the user will see and use to continue using the app
//It basicall starts the App
public class AppUI extends StackPane {
	
	private Button  btnStart, btnClose;
	private ImageView imgV;
	private VBox layout;
	//text streams
		private BufferedReader txtin=null;
		private PrintWriter txtout= null;
		
		//binary Streams
		private DataInputStream dis=null;
		private DataOutputStream dos=null;
		
		//bytes streams
		private OutputStream out =null;
		private InputStream in =null;
		private Socket s;
		
		public AppUI() {
			
			this.setPrefSize(1060, 600);
			
			 Image mImg = new Image("./data/a/B.jpg");
			 BackgroundImage bb= new BackgroundImage(mImg, null, null, null, null);
			 
			 Background myback = new Background(bb);
			 this.setBackground(myback);
		
		     layout= new VBox();
		
		    GridPane gPane = new GridPane();
		    Image myImg = new Image("./data/icon.png");
		    imgV= new ImageView();
		    imgV.setImage(myImg);
		
			btnStart= new Button("Start Editing ");

			btnStart.setTranslateX(200);
			btnStart.setTranslateY(400);
			
			
			btnClose= new Button();
			btnClose.setTranslateX(250);
			btnClose.setTranslateY(400);

	     	layout.getChildren().add(0, btnStart);
	     	gPane.add(imgV, 0,3,2, 1);
			gPane.add(btnStart, 3,3);
			
			this.getChildren().add(gPane);

			
			 //button to start the app
			    btnStart.setOnAction(e->{
				connect("localhost", 5000);
				layout.setVisible(false);
				ClientPane CP = new ClientPane();
				this.getChildren().add(CP);
				
				
			});
			}

		//method to connect to local host server
		private void connect(String string, int i) {
			// TODO Auto-generated method stub
			try {
				System.out.println("Client Connecting...");
				
				s = new Socket(string,i); 
				
				out = s.getOutputStream();
				in = s.getInputStream();
				
				dos = new DataOutputStream(out);
				dis = new DataInputStream(in);
				
				txtin= new BufferedReader(new InputStreamReader(in));
				txtout = new PrintWriter(out);
				System.out.println("Connection Established");
				
				
			}catch(UnknownHostException e) {
				e.printStackTrace();
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}	
		}
		}
		
		


