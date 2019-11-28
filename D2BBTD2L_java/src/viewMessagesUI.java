
import java.sql.Timestamp;
import java.util.ArrayList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class handles all of the GUI aspects of the viewMessages use case
 * @author Brennan Couturier, 3638808
 *
 */
public class viewMessagesUI
{

	//Non-javafx variables
	//-------------------------------------------------------------------------------

	private viewMessagesControl vmc;
	
	private ArrayList<Message> deletedMessages;
	
	private Boolean currentlyViewingSent;
	
	private Boolean currentlyViewingReceived;

	//-------------------------------------------------------------------------------

	//Javafx variables
	//-------------------------------------------------------------------------------
	
	private Button btnSentItems;
	
	private Button btnReceivedItems;

	private Button btnNewMessage;

	private Button btnExit;
	
	private Button btnDeleteMessage;

	private GridPane viewMessagesPane;

	private Scene scViewMessages;

	private ListView<Message> messagesList;

	private Label lblTxtMessage;

	private Label lblFromTo;

	private Label lblName;

	private Label lblDate;

	//-------------------------------------------------------------------------------

	public viewMessagesUI()
	{
		vmc = new viewMessagesControl();
	}

	private void initViewMessagesComponents()
	{
		currentlyViewingSent = false;
		currentlyViewingReceived = true;
		initMessagesTable();
		
		deletedMessages = new ArrayList<Message>();

		lblTxtMessage = new Label("");
		lblTxtMessage.setPrefSize(480, 400);
		lblTxtMessage.setStyle("-fx-background-color: WHITE");
		lblTxtMessage.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		lblTxtMessage.setWrapText(true);
		lblTxtMessage.setAlignment(Pos.TOP_LEFT);
		//t.setFont(Font.font ("Verdana", 20));
		lblTxtMessage.setFont(Font.font("Helvetica", 14));

		lblFromTo = new Label("From:");
		lblFromTo.setPrefWidth(50);
		lblFromTo.setAlignment(Pos.CENTER_RIGHT);
		lblFromTo.setFont(Font.font("Helvetica", 14));

		lblName = new Label("");
		lblName.setPrefWidth(150);
		lblName.setFont(Font.font("Helvetica", 14));

		lblDate = new Label("");
		lblDate.setPrefWidth(150);
		lblDate.setFont(Font.font("Helvetica", 14));

		btnExit = new Button("Back");
		btnExit.setOnAction(this::processExitButtonPress);
		btnExit.setPrefWidth(50);
		
		btnDeleteMessage = new Button("Delete");
		btnDeleteMessage.setOnAction(this::processDeleteButtonPress);
		btnDeleteMessage.setPrefWidth(150);
		btnDeleteMessage.setDisable(true);

		btnSentItems = new Button("Sent Items");
		btnSentItems.setOnAction(this::processSentItemsButtonPress);
		btnSentItems.setPrefWidth(150);

		btnReceivedItems = new Button("Inbox");
		btnReceivedItems.setOnAction(this::processReceivedItemsButtonPress);
		btnReceivedItems.setPrefWidth(150);

		btnNewMessage = new Button("New Message");
		btnNewMessage.setOnAction(this::processNewMessageButtonPress);
		btnNewMessage.setPrefWidth(150);

		viewMessagesPane = new GridPane();
		viewMessagesPane.setHgap(10);
		viewMessagesPane.setVgap(10);
		viewMessagesPane.setAlignment(Pos.CENTER);
		viewMessagesPane.setStyle("-fx-background-color: whitesmoke");
		//viewMessagesPane.setGridLinesVisible(true);
	}

	public Scene initViewMessagesScene()
	{
		initViewMessagesComponents();
		displayMessagesReceived(MainMenu.getUserAccount().getAccountId());
		
		btnReceivedItems.setDisable(true);
		
		viewMessagesPane.add(btnDeleteMessage, 0, 7);
		viewMessagesPane.add(btnExit, 5, 1);
		viewMessagesPane.add(lblFromTo, 2, 5);
		viewMessagesPane.add(lblName, 3, 5);
		viewMessagesPane.add(lblDate, 4, 5);
		viewMessagesPane.add(lblTxtMessage, 2, 2, 4, 10);
		viewMessagesPane.add(btnSentItems, 0, 6);
		viewMessagesPane.add(btnReceivedItems, 0, 5);
		viewMessagesPane.add(btnNewMessage, 0, 1);
		viewMessagesPane.add(messagesList, 1, 1, 1, 10);

		scViewMessages = new Scene(viewMessagesPane, 900, 600);
		return scViewMessages;

	}

	public void displayViewMessages(Stage stg)
	{
		stg.setScene(initViewMessagesScene());
		stg.show();
	}

	public void displayMessagesReceived(int userId)
	{		
		Message[] messages = vmc.getMessagesReceived(MainMenu.getUserAccount().getAccountId());
		
		messagesList.getItems().clear();
		
		for(Message m : messages)
		{
			messagesList.getItems().add(m);
		}
		messagesList.setOnMouseClicked(this::processReceivedMessageChosen);
		
	}

	public void displayMessagesSent(int userId)
	{
		Message[] messages = vmc.getMessagesSent(MainMenu.getUserAccount().getAccountId());
		
		messagesList.getItems().clear();
		
		for(Message m : messages)
		{
			messagesList.getItems().add(m);
		}
		messagesList.setOnMouseClicked(this::processReceivedMessageChosen);		
	}


	private void processSentItemsButtonPress(ActionEvent event)
	{
		currentlyViewingSent = true;
		currentlyViewingReceived = false;
		displayMessagesSent(MainMenu.getUserAccount().getAccountId());
		lblFromTo.setText("To:");
		btnReceivedItems.setDisable(false);
		btnSentItems.setDisable(true);
		resetMessageDetails();
	}

	private void processReceivedItemsButtonPress(ActionEvent event)
	{
		currentlyViewingSent = false;
		currentlyViewingReceived = true;
		displayMessagesReceived(MainMenu.getUserAccount().getAccountId());
		lblFromTo.setText("From:");
		btnReceivedItems.setDisable(true);
		btnSentItems.setDisable(false);
		resetMessageDetails();
	}

	
	private void processNewMessageButtonPress(ActionEvent event)
	{
		postMessageUI pmu = new postMessageUI();

		pmu.displayCreateMessageForm(MainMenu.getStage());
	}

	private void processExitButtonPress(ActionEvent event)
	{
		//if student is logged in
		StudentMainMenu smm = new StudentMainMenu();
		smm.resetToMainMenu();
	}

	private void processReceivedMessageChosen(MouseEvent event)
	{
		Message m =  messagesList.getSelectionModel().getSelectedItem();
		if(Message.wasReceived(m))
		{
			lblName.setText(m.getFromAccount().getFullName());
		}
		else
		{
			lblName.setText(m.getToAccount().getFullName());
		}
				
		lblTxtMessage.setText(" " + m.getMessageText());
		Timestamp timeSent = m.getTimeSent();
		lblDate.setText(timeSent.getMonth() + "/"+ timeSent.getDate() + "/" + (timeSent.getYear() + 1900));
		btnDeleteMessage.setDisable(false);
	}

	public void resetToViewMessagesUI()
	{
		displayViewMessages(MainMenu.getStage());
	}
	
	private void resetMessageDetails()
	{
		lblName.setText("");
		lblTxtMessage.setText("");
		lblDate.setText("");
		btnDeleteMessage.setDisable(true);
	}
	
	private void processDeleteButtonPress(ActionEvent event)
	{
		Message m = messagesList.getSelectionModel().getSelectedItem();
		messagesList.getItems().remove(m);
		resetMessageDetails();
		
	}

	private void initMessagesTable()
	{
		messagesList = new ListView<Message>();
		messagesList.setCellFactory(param -> new ListCell<Message>() {
		    @Override
		    protected void updateItem(Message item, boolean empty) {
		        super.updateItem(item, empty);

		        if(currentlyViewingReceived)
		        {
		        	if (empty || item == null || item.getReceivedDescription() == null) {
			            setText(null);
			        } else {
			            setText(item.getReceivedDescription());
			        }
		        }
		        else
		        {
		        	if (empty || item == null || item.getSentDescription() == null) {
			            setText(null);
			        } else {
			            setText(item.getSentDescription());
			        }
		        }
		        
		    }
		});
		messagesList.setPrefSize(200, 500);
	}
}
