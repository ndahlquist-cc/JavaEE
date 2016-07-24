/**
 * PROG3060 - Exercise 3
 * Nicole Dahlquist
 * Created: July 23, 2016
 * Team Class - Represents a team object from the LeagueDB
 */


import javax.persistence.*;

import java.util.Set;

@Entity
/**
 * Entity class for the Team table in the league database
 * @author Nicole Dahlquist
 *
 */
public class Team {
		
	//Class scope variables and constants
	private String teamId;
	private String teamName;
	private String sponsor;
	private String website;
	private Set rosters;
	private String league;
	
	@Id
	public String getTeamId() {
		return teamId;
	}
	
	public void setTeamId(String teamID) {
		this.teamId = teamID;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@OneToMany(targetEntity=Roster.class)
	@JoinColumn(name="team")
	public Set getRosters(){
		return rosters;
	}
	
	public void setRosters(Set rosters){
		this.rosters = rosters;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}
}
