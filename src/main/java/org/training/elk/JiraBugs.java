package org.training.elk;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="jirabugs",type="bugs")
public class JiraBugs {
	@Id
	private String issue_key;
	private String issue_type;
	private String summary;
	private String status;
	private String project_key;
	private String project_name;
	private String project_type;
	private String assignee;
	private String reporter;
	private String created_date;
	private String updated_date;
	public JiraBugs() {
		super();
	}
	public JiraBugs(String summary, String issue_key, String issue_type, String status,
			String project_key, String project_name, String project_type, String assignee, String reporter,
			String created_date, String updated_date) {
		super();
		this.issue_type = issue_type;
		this.summary = summary;
		this.issue_key = issue_key;
		this.status = status;
		this.project_key = project_key;
		this.project_name = project_name;
		this.project_type = project_type;
		this.assignee = assignee;
		this.reporter = reporter;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}
	
	public String getIssue_type() {
		return issue_type;
	}
	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIssue_key() {
		return issue_key;
	}
	public void setIssue_key(String issue_key) {
		this.issue_key = issue_key;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProject_key() {
		return project_key;
	}
	public void setProject_key(String project_key) {
		this.project_key = project_key;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}
	
}
