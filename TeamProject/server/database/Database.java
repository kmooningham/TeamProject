package server.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import server.models.Player;

import java.sql.SQLException;

public class Database {
	public static final String filename = "db.properties";

	private Connection connection;
	private String encryptionKey;
	private Properties props;

	public Database() {
		try {
			props = new Properties();
			props.load(new FileInputStream(filename));
			encryptionKey = props.getProperty("enc_key");
			createConnection();
		} catch (IOException e) {
			System.out.println("Fatal: unable to read db.properties.");
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("Fatal: unable to establish MySQL connection");
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void createConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			String url = props.getProperty("url");
			connection = DriverManager.getConnection(url, props);
		}
	}

	public Player authenticatePlayer(username, password) {
		try {
			createConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT id, username, wins FROM players WHERE username = ? AND password = ?");
			stmt.setString(1, data.getUsername());
			stmt.setString(2, data.getPassword());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) { // if no player with username/password combo exists, this will be false
				Player p = new Player();
				p.setUsername(data.getUsername());
				p.setId(rs.getInt(1));
				p.setXp(rs.getInt(2));
				p.setWins(rs.getInt(3));
				p.setLosses(rs.getInt(4));
				p.setClient(client);
				return p;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return null;
	}

	public void updatePlayerData(Player player) {
		try {
			createConnection();

			PreparedStatement stmt = connection.prepareStatement("UPDATE players SET  wins = ? WHERE id = ?;");
			stmt.setInt(2, player.getWins());
			stmt.setInt(4, player.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// quick test 
	/*
	public static void main(String[] args) {
		Database db = new Database();

		try {
			db.createAccount(new CreateAccountData("thisisausername","yoooooo1"));
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		try {
			db.createAccount(new CreateAccountData("thisisausername","yoo111"));
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		Player p = db.authenticatePlayer(new PlayerLoginData("thisisausername", "yoooooo1"), null);

		System.out.println(p);

		p.setWins(1000);

		db.updatePlayerData(p);
	}*/
}
