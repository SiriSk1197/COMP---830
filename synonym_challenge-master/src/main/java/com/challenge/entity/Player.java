package com.challenge.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name = "player")
public class Player implements java.io.Serializable {

	private static final long serialVersionUID = -2107661175822965352L;
	private Integer playerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userId;
	private String userPassword;

	public Player() {
	}
	
	public Player(Integer playerId) {
		this.playerId = playerId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "player_id", unique = true, nullable = false)
	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	@Column(name = "first_name", unique = true, nullable = false)
	@XmlAttribute(name = "firstName")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	@XmlAttribute(name = "lastName")
	public String getLastName() {
		return this.lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Column(name = "email_id", nullable = false)
	@XmlAttribute(name = "emailId")
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "user_id", nullable = false)
	@XmlAttribute(name = "userId")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_password", nullable = false)
	@XmlAttribute(name = "userPassword")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
