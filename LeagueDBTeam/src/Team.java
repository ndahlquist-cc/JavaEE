/**
 * Nicole Dahlquist
 * PROG3060 - Exercise 2
 * Class definition for the Team object in LeagueDB 
 */

public class Team {

	private String teamID;
	private League league;
	private String sponsor;
	private String teamName;
	private Staff headCoach;
	private Staff asstCoach;
	private Staff trainer;
	private Staff manager;
	private String website;

	public Team() {
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League name) {
		this.league = name;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String name) {
		this.sponsor = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String name) {
		this.teamName = name;
	}

	public Staff getHeadCoach() {
		return headCoach;
	}

	public void setHeadCoach(Staff headCoach) {
		this.headCoach = headCoach;
	}

	public Staff getAsstCoach() {
		return asstCoach;
	}

	public void setAsstCoach(Staff asstCoach) {
		this.asstCoach = asstCoach;
	}

	public Staff getTrainer() {
		return trainer;
	}

	public void setTrainer(Staff trainer) {
		this.trainer = trainer;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String url) {
		this.website = url;
	}
}
