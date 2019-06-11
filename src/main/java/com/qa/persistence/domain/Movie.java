package com.qa.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieID;
	@Column (length = 20)
	private String title;
	@Column (length = 30)
	private int releaseYear;
	@Column (length = 30)
	private int runTime;
	@Column (length = 30)
	private String certification;
	@Column (length = 30)
	private int rating;
	
	
	public Movie(int id, String title, int releaseYear, int runTime, String certification, int rating) {
		super();
		this.movieID = movieID;
		this.title = title;
		this.releaseYear = releaseYear;
		this.runTime = runTime; 
		this.certification = certification;
		this.rating = rating;
	}

	public Movie() {
		
	}
	
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getReleaseYear() {
		return releaseYear;
	}



	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
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
