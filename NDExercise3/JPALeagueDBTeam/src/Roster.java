/**
 * PROG3060 - James Wong
 * Nicole Dahlquist
 * Created: July 16, 2016
 * Roster Class - Represents a roster from the LeagueDB
 */


import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.mapping.Set;

@Entity
public class Roster {
	private int rosterId;
	private Player player;
	private Team team;
	private int jersey;
	private String positon;
	private Set playerStats;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRosterId() {
		return rosterId;
	}
	
	public void setRosterId(int rosterId) {
		this.rosterId = rosterId;
	}
	
	@ManyToOne
	@JoinColumn(nullable=false)
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@ManyToOne
	@JoinColumn(nullable=false)
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public int getJersey() {
		return jersey;
	}
	
	public void setJersey(int jersey) {
		this.jersey = jersey;
	}
	
	public String getPositon() {
		return positon;
	}
	
	public void setPositon(String positon) {
		this.positon = positon;
	}
	
}