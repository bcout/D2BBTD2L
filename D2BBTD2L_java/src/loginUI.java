import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class loginUI 
{
	private Boolean loginSuccessful;
	
	private Account user;
	private String username;
	private String password;
	
	private Image mainMenuLogo;
	private ImageView mainMenuLogoView;
	private Image mainMenuIcon;
	private ImageView mainMenuIconView;
	private Scene scLogin;
	private GridPane loginPane;
	private Label lblUsername;
	private Label lblPassword;
	private TextField txtUsername;
	private PasswordField txtPassword;
	private Button btnLogin;
	private Button btnQuit;
	
	public void displayLoginForm(Stage stg) 
	{
		stg.setScene(initLogin());
		stg.show();
	}
	
	private void initLoginComponents()
	{
		try 
		{
			mainMenuLogo = new Image(new FileInputStream("images/D2BBTD2L_Logo.png"));
			mainMenuIcon = new Image(new FileInputStream("images/logo.png"));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e.getMessage());
		}
		mainMenuLogoView = new ImageView(mainMenuLogo);
		mainMenuLogoView.setFitHeight(160);
		mainMenuLogoView.setFitWidth(489);
		
		mainMenuIconView = new ImageView(mainMenuIcon);
		mainMenuIconView.setFitHeight(100);
		mainMenuIconView.setFitWidth(100);		
		
		txtUsername = new TextField("");
		txtUsername.setPrefWidth(150);
		
		txtPassword = new PasswordField();
		txtPassword.setPrefWidth(150);
		txtPassword.setSkin(new PasswordSkin(txtPassword));
		
		lblUsername = new Label("Username:");
		lblUsername.setPrefWidth(80);
		lblUsername.setAlignment(Pos.CENTER_RIGHT);
		
		lblPassword = new Label("Password:");
		lblPassword.setPrefWidth(80);
		lblPassword.setAlignment(Pos.CENTER_RIGHT);
		
		btnLogin = new Button("Login");
		btnLogin.setOnAction(this::processLoginButtonPress);
		btnLogin.setPrefWidth(150);
		
		btnQuit = new Button("Quit");
		btnQuit.setOnAction(this::processExitButtonPress);
		btnQuit.setPrefWidth(80);
		
		loginPane = new GridPane();
		loginPane.setHgap(20);
		loginPane.setVgap(20);
		loginPane.setAlignment(Pos.CENTER);
	}
	
	private Scene initLogin()
	{
		initLoginComponents();
		loginPane.add(txtUsername, 3, 1);
		loginPane.add(txtPassword, 3, 2);
		loginPane.add(lblUsername, 2, 1);
		loginPane.add(lblPassword, 2, 2);
		loginPane.add(mainMenuIconView, 1, 0);
		loginPane.add(btnQuit, 6, 0);
		loginPane.add(btnLogin, 3, 4);
		loginPane.setStyle("-fx-background-color: WHITE");
		//loginPane.setGridLinesVisible(true);
		
		scLogin = new Scene(loginPane, 900, 600);
		return scLogin;
	}

	private void enterCredentials() 
	{
		
	}

	private void displayLoginConfirmation() 
	{
		Account tempUser = new Account(1, "TestUsername", "TestPassword", 1, "Brennan", "Couturier");
		MainMenu.setUser(tempUser);
		MainMenu.displayMainMenu();
	}
	
	private void processLoginButtonPress(ActionEvent event)
	{
		displayLoginConfirmation();
	}
	
	private void processExitButtonPress(ActionEvent event)
	{
		MainMenu.getStage().close();
	}
	
}