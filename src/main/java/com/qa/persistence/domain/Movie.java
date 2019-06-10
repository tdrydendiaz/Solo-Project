package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (length = 20)
	private String title;
	@Column (length = 30)
	private String releaseDate;
	@Column (length = 30)
	private int runTime;
	@Column (length = 30)
	private String certification;
	@Column (length = 30)
	private int rating;
	
	
	public Movie(int id, String title, String releaseDate, int runTime, String certification, int rating) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.runTime = runTime;
		this.certification = certification;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	public int getRunTime() {
		return runTime;
	}



	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}



	public String getCertification() {
		return certification;
	}



	public void setCertification(String certification) {
		this.certification = certification;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	



//	@Override
//    public String toString() {
//    	return String.format(firstName + " " + lastName + " owns " + accountNumber);
//    }
	
}
