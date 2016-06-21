/**
 * Nicole Dahlquist PROG3060 - Exercise 2 
 * Class definition for the League object in LeagueDB
 */

public class League {

	private String leagueID;
	private String leagueName;
	private String leagueSponsor;

	public League() {
	}

	public String getLeagueID() {
		return leagueID;
	}

	public void setLeagueID(String leagueID) {
		this.leagueID = leagueID;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueSponsor() {
		return leagueSponsor;
	}

	public void setLeagueSponsor(String leagueSponsor) {
		this.leagueSponsor = leagueSponsor;
	}
}
