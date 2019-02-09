package com.example;

public class Complaints {
	private int complaintid;
	private String category;
	private String issue;
	private String description;
	private String cmethod;
	private String requestedby;
	private String status;
	private String comments;

	public int getComplaintid() {
		return complaintid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCmethod() {
		return cmethod;
	}
	public void setCmethod(String cmethod) {
		this.cmethod = cmethod;
	}
	public String getRequestedby() {
		return requestedby;
	}
	public void setRequestedby(String requestedby) {
		this.requestedby = requestedby;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
