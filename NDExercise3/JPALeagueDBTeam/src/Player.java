/**
 * PROG3060 - James Wong
 * Nicole Dahlquist
 * Created: July 16, 2016
 * Player Class - Represents a player object from the LeagueDB
 */

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.mapping.Set;

@Entity
public class Player {

	private int playerId;
	private String lastName;
	private String firstName;
	private double height;
	private double weight;
	private Date dob;
	private String school;
	private String streetAddress;
	private String city;
	private String state_province;
	private String postalCode;
	private String country;
	private String phone;
	private String mobile;
	private String email;
	private Set rosters;
	private Set playerStats;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	@Column(nullable=false)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(nullable=false)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState_province() {
		return state_province;
	}
	
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(targetEntity=Roster.class)
	@JoinColumn(name="player")
	public Set getRosters(){
		return rosters;
	}
	
}
