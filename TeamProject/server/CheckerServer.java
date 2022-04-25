package server;
//
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class CheckerServer extends AbstractServer
{
  // Data fields for this chat server.
  private JTextArea log;
  private JLabel status;
  private boolean running = false;
  private Database database;
  
  // Constructor for initializing the server with default settings.
  public CheckerServer()
  {
    super(12345);
    this.setTimeout(500);
  }

  // Getter that returns whether the server is currently running.
  public boolean isRunning()
  {
    return running;
  }
  
  // Setters for the data fields corresponding to the GUI elements.
  public void setLog(JTextArea log)
  {
    this.log = log;
  }
  public void setStatus(JLabel status)
  {
    this.status = status;
  }
  public void setDatabase(Database database)
  {
	this.database = database;
  }

  // When the server starts, update the GUI.
  public void serverStarted()
  {
    running = true;
    status.setText("Listening");
    status.setForeground(Color.GREEN);
    log.append("Server started\n");
  }
  
  // When the server stops listening, update the GUI.
   public void serverStopped()
   {
     status.setText("Stopped");
     status.setForeground(Color.RED);
     log.append("Server stopped accepting new clients - press Listen to start accepting new clients\n");
   }
 
  // When the server closes completely, update the GUI.
  public void serverClosed()
  {
    running = false;
    status.setText("Close");
    status.setForeground(Color.RED);
    log.append("Server and all current clients are closed - press Listen to restart\n");
  }

  // When a client connects or disconnects, display a message in the log.
  public void clientConnected(ConnectionToClient client)
  {
    log.append("Client " + client.getId() + " connected\n");
  }

  // When a message is received from a client, handle it.
  /*
   * 1.	Verify that a username has not already been used for a “Create Account”  request and subsequently store the newly 
   *    selected username and encrypted password in the User table.
   *    
   * 2.	Verify that the username /password combination exists  for a “Login” request.
   */
  
  public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
  {
	  /*
    // If we received LoginData, verify the account information.
    if (arg0 instanceof LoginData)
    {
      // Check the username and password with the database.
      LoginData data = (LoginData)arg0;
      Object result;
      String query = "select * from users where username = " + data.getUsername();
      ArrayList<String> a = database.query(query);
      if (a == null) //if username does not exist
      {
    	  result = new Error("The username does not exist", "Login");
          log.append("Client " + arg1.getId() + " failed to log in\n");
      }
      else
      {
    	String password = a.get(0);
        result = new Error("The username and password are incorrect.", "Login");
        log.append("Client " + arg1.getId() + " failed to log in\n");
      }
      
      // Send the result to the client.
      try
      {
        arg1.sendToClient(result);
      }
      catch (IOException e)
      {
        return;
      }
    }
    
    // If we received CreateAccountData, create a new account.
    else if (arg0 instanceof CreateAccountData)
    {
      // Try to create the account.
      CreateAccountData data = (CreateAccountData)arg0;
      Object result = null;
      String query = "select * from users where username = " + data.getUsername();
      ArrayList<String> a = database.query(query);
      if (a == null) //null means its ok to create a new account
      {  
          //Create the new account by inserting into database using executeDML
    	  String query2 = "insert into Users values('" + data.getUsername() + "'," + "aes_encrypt('" + data.getPassword() + "',key)";
    	  database.query(query2);
      }
      else  //Username already there, so reject
      {
  
        result = new Error("The username already in use.", "Login");
        log.append("Client " + arg1.getId() + " failed to log in\n");
      }
      
      // Send the result to the client.
      try
      {
        arg1.sendToClient(result);
      }
      catch (IOException e)
      {
        return;
      }
      */
    
  }

  // Method that handles listening exceptions by displaying exception information.
  public void listeningException(Throwable exception) 
  {
    running = false;
    status.setText("Exception occurred while listening");
    status.setForeground(Color.RED);
    log.append("Listening exception: " + exception.getMessage() + "\n");
    log.append("Press Listen to restart server\n");
  }
}
