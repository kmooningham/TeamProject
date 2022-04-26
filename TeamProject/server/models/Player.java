package server.models;


import java.util.Objects;

public class Player {

	private int id;
	private String username;
	private int xp;
	private int wins;
	private int losses;

	public Player(int id, String username, int wins) {
		this.id = id;
		this.username = username;
		this.wins = wins;
	}

	public Player() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public String toString() {
		return "Player{" +
				"id=" + id +
				", username='" + username + '\'' +
				", wins=" + wins +
				'}';
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return id == player.id;
	}
	
	public int hashCode() {
		return Objects.hash(id);
	}
}