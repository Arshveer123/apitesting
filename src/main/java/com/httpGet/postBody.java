package com.httpGet;

public class postBody {
	
	
	String name;
	String job;
	String id;
	String createdAt;

	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public postBody() {
		
	}
	public postBody(String name, String job) {
		this.name = name;
		this.job = job;
		
	}

	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getJob() {
		return job;
	}

	
	public void setJob(String job) {
		this.job = job;
	}

}
