package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int characterID;
	@Column (length = 70)
	private String characterName;
	@Column (length = 70)
	private String actorName;
	private int powerRating;
	@Column (length =20)
	private String morality;
	@Column (length =20)
	private String gender;
	@Column (length =60)
	private String homeworld;
	
	public Character(int characterID, String characterName, String actorName, int powerRating, String morality,
			String gender, String homeworld) {
		
		super();
		this.characterID = characterID;
		this.characterName = characterName;
		this.actorName = actorName;
		this.powerRating = powerRating;
		this.morality = morality;
		this.gender = gender;
		this.homeworld = homeworld;
	}
	
 public Character() {
		
	}
	
	public int getCharacterID() {
		return characterID;
	}
	public void setCharacterID(int characterID) {
		this.characterID = characterID;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public int getPowerRating() {
		return powerRating;
	}
	public void setPowerRating(int powerRating) {
		this.powerRating = powerRating;
	}
	public String getMorality() {
		return morality;
	}
	public void setMorality(String morality) {
		this.morality = morality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeworld() {
		return homeworld;
	}
	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}
	
	@Override
    public String toString() {
    	return String.format(characterName + " is played by" + actorName);
    }
	
	
}
