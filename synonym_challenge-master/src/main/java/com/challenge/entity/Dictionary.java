package com.challenge.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;


@Entity
@Table(name = "dictionary")
public class Dictionary implements java.io.Serializable {

	private static final long serialVersionUID = -2107661175822965352L;
	private Integer wordId;
	private String word;
	private String synonym1;
	private String synonym2;
	private String synonym3;

	public Dictionary() {
	}
	
	public Dictionary(Integer wordId) {
		this.wordId = wordId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "word_id", unique = true, nullable = false)
	public Integer getWordId() {
		return wordId;
	}

	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	@Column(name = "word", nullable = false)
	@XmlAttribute(name = "word")
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	@Column(name = "synonym_1", nullable = false)
	@XmlAttribute(name = "synonym1")
	public String getSynonym1() {
		return this.synonym1;
	}

	public void setSynonym1(String synonym1) {
		this.synonym1 = synonym1;
	}

	@Column(name = "synonym_2", nullable = false)
	@XmlAttribute(name = "synonym2")
	public String getSynonym2() {
		return this.synonym2;
	}

	public void setSynonym2(String synonym2) {
		this.synonym2 = synonym2;
	}

	@Column(name = "synonym_3", nullable = false)
	@XmlAttribute(name = "synonym3")
	public String getSynonym3() {
		return this.synonym3;
	}

	public void setSynonym3(String synonym3) {
		this.synonym3 = synonym3;
	}


}
