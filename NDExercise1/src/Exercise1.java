/* Nicole Dahlquist
 * Exercise 1
 * PROG3060 - James Wong
 * Due Date: June 2, 2016
 */
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import org.apache.derby.jdbc.ClientDataSource;

public class Exercise1 {
	// class-level variables
	private static Connection conn = null;
	
	/**
	 * The method to be executed on run
	 * @param args - whatever you need to pass in
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		if(conn == null){
			getConnection();
		}
		conn.setAutoCommit(false);
		String query = "CREATE TABLE NDAHLQUIST.ARENA ( " +
				"arenaID INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
				"arenaName VARCHAR(40) NOT NULL, " +
				"streetAddress VARCHAR(50), " + 
				"city VARCHAR(30), " +
				"state_province VARCHAR(20), " +
				"postalCode CHAR(7), " +
				"country VARCHAR(30), " +
				"phone CHAR(10), " +
				"capacity INT )";
		Statement stmt = null;	
		
		try {
			if(conn != null)
			{
				stmt = conn.createStatement();
				stmt.execute(query);									
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		insertArena("Montreal arena", "123 Rue Taquine", "Montreal", "QC", "Q1Q1Q1", "Canada", "7775551212", 100000);		
		insertArena("Boston arena", "123 Boston St.", "Boston", "MA", "12345", "USA", "8885551212", 500000);
		insertArena("Pitts arena", "123 Pitty Ave.", "Pittsburgh", "PA", "23456", "USA", "9995551212", 400000);
		insertArena("Vancouver arena", "123 Canuck Cres", "Vancouver", "BC", "V1V1V1", "Canada", "1115551212", 700000);
		insertArena("Toronto arena", "123 Kenogami", "Toronto", "ON", "T1T1T1", "Canada", "2225551212", 900000);
		insertArena("Detroit arena", "123 Tiger Blvd.", "Detroit", "MI", "34567", "USA", "3335551212", 600000);
		insertArena("Chicago arena", "123 Sock St.", "Chicago", "IL", "45678", "USA", "4445551212", 300000);
		insertArena("Newark arena", "123 Newark Rd.", "Newark", "NJ", "56789", "USA", "5555551212", 200000);
		String selectQuery = "SELECT * FROM NDAHLQUIST.ARENA";
		ResultSet rs = stmt.executeQuery(selectQuery);
		try {			
			while(rs.next()){
				int arenaID = rs.getInt("arenaID");
				String arenaName = rs.getString("arenaname");
				String address = rs.getString("streetAddress");
				String city = rs.getString("city");
				String state_prov = rs.getString("state_province");
				String zip_postal = rs.getString("postalCode");
				String country = rs.getString("country");
				String phone = rs.getString("phone");
				phone = String.format("(%s) %s-%s", phone.substring(0, 3), phone.substring(3, 6), 
						phone.substring(6, 10));
				int capacity = rs.getInt("capacity");
				System.out.println(arenaID + "\t" + arenaName + "\t\t" + address + "\t\t" + 
						city + ", " + state_prov + "\t" + zip_postal +
						"\t" + country + "\t" + phone + "\tcapacity: " + capacity);
			}
		}
		catch(SQLException e){ 
			e.printStackTrace();
		}
		finally{
			stmt.close();
			rs.close();
		}
		conn.rollback();
		conn.close();
	}
	/**
	 * Insert a team into the arena db
	 * @param name - arena name
	 * @param address - arena address	
	 * @param city - city arena is located in
	 * @param state_prov - the state/prov the arena is in
	 * @param zip_postal - the zip or postal code of the arena
	 * @param country - the country the arena is in
	 * @param phone - the phone number of the arena
	 * @param capacity - the number of people the arena can hold
	 * @throws SQLException
	 */
	public static void insertArena
	(String name, String address, String city, String state_prov, String zip_postal, 
	String country, String phone, int capacity) throws SQLException{
		PreparedStatement ps = null;
		String query = "INSERT INTO NDAHLQUIST.ARENA " +
				"(arenaName, streetAddress, city, state_province, postalCode, country, phone, capacity) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			if(conn == null){
				getConnection();
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, city);
			ps.setString(4, state_prov);
			ps.setString(5, zip_postal);
			ps.setString(6, country);
			ps.setString(7, phone);
			ps.setInt(8, capacity);
			ps.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			ps.close();
		}
	}
	/** 
	 * Tries to get a connection
	 * @return a Connection
	 * @throws SQLException 
	 */	
	public static void getConnection() throws SQLException {
		ClientDataSource cds = new ClientDataSource();
		try
		{
			cds.setServerName("localhost");
			cds.setPortNumber(1527);
			cds.setDatabaseName("G:\\LeagueDB\\leagueDB;");
			//cds.setDatabaseName("c:\\Users\\Nicole\\DerbyLeagueDB\\LeagueDB");
			
			cds.setUser("ndahlquist");
			cds.setPassword("password");
			
			PrintWriter pw = new PrintWriter(new FileOutputStream("trace.log"));
			cds.setLogWriter(pw);
			
			cds.setTraceLevel(ClientDataSource.TRACE_RESULT_SET_CALLS);
					
			if(conn == null) {
				conn = cds.getConnection();
			}			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
