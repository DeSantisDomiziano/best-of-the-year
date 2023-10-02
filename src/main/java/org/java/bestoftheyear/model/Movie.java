package org.java.bestoftheyear.model;

public class Movie {
	private int id;
	private String title;
	
	public Movie(String title,int id) {
		setId(id);
		setTitle(title);
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + "]";
	}
}
