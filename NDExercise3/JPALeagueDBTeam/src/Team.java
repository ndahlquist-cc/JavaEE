/**
 * PROG3060 - James Wong
 * Nicole Dahlquist
 * Created: July 16, 2016
 * Team Class - Represents a team object from the LeagueDB
 */


import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.mapping.Set;

@Entity
public class Team {
		
	private String teamId;
	private League league;
	private String teamName;
	private Staff headCoach;
	private Staff asstCoach;
	private Staff trainer;
	private Staff manager;
	private String sponsor;
	private String website;
	private Set rosters;
	private Set homeGames;
	private Set visitorGames;
	
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
	
	@ManyToOne
	@JoinColumn(nullable=true)
	public Staff getHeadCoach() {
		return headCoach;
	}
	
	public void setHeadCoach(Staff headCoach) {
		this.headCoach = headCoach;
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

	@ManyToOne
	@JoinColumn(nullable=true)
	public Staff getAsstCoach() {
		return asstCoach;
	}
	
	public void setAsstCoach(Staff asstCoach) {
		this.asstCoach = asstCoach;
	}

	@ManyToOne
	@JoinColumn(nullable=true)
	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	@ManyToOne
	@JoinColumn(nullable=true)
	public Staff getTrainer() {
		return trainer;
	}

	public void setTrainer(Staff trainer) {
		this.trainer = trainer;
	}

	@ManyToOne
	@JoinColumn(nullable=false)
	public League getLeague() {
		return league;
	}
	
	public void setLeague(League league) {
		this.league = league;
	}

	@OneToMany(targetEntity=Roster.class)
	@JoinColumn(name="team")
	public Set getRosters(){
		return rosters;
	}
	
}
