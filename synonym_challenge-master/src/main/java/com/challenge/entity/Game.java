package com.challenge.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name = "game")
public class Game implements java.io.Serializable {

	private static final long serialVersionUID = -2107661175822965352L;
	private Integer gameId;
	private Dictionary word;
	private Player player;
	private Integer score;
	private String response1;
	private String response2;
	private String response3;

	public Game() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id", unique = true, nullable = false)
	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

    @OneToOne(targetEntity = Dictionary.class)
    @JoinColumn(name = "word_Id")
	@XmlAttribute(name = "wordId")
	public Dictionary getWord() {
		return word;
	}

	public void setWord(Dictionary word) {
		this.word = word;
	}
	
    @OneToOne(targetEntity = Player.class)
    @JoinColumn(name = "player_Id")
	@XmlAttribute(name = "playerId")
	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Column(name = "score")
	@XmlAttribute(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "response_1")
	@XmlAttribute(name = "response1")
	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}
	
	@Column(name = "response_2")
	@XmlAttribute(name = "response2")
	public String getResponse2() {
		return response2;
	}

	public void setResponse2(String response2) {
		this.response2 = response2;
	}

	@Column(name = "response_3")
	@XmlAttribute(name = "response3")
	public String getResponse3() {
		return response3;
	}

	public void setResponse3(String response3) {
		this.response3 = response3;
	}



}
