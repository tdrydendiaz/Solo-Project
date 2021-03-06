package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieID;
	@Column (length = 60)
	private String title;
	private int releaseYear;
	private int runTime;
	@Column (length = 30)
	private String certification;
	private int rating;
	
	
	public Movie(int movieID, String title, int releaseYear, int runTime, String certification, int rating) {
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


	
}
