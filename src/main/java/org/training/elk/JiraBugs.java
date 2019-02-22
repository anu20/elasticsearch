package org.training.elk;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="jirabugs",type="bugs")
public class JiraBugs {
	@Id
	private String issue_key;
	private String project_key;
	private String project_name;
	private String summary;
	private String labels;
	private String issue_type;
	private String assignee;
	private String description;
	private String status;
	private String reporter;
	private String created;
	private String updated;
	private String comments;
	public JiraBugs() {
		super();
	}
	public JiraBugs(String issue_key, String project_key, String project_name, String summary, String labels,
			String issue_type, String assignee, String description, String status, String reporter, String created,
			String updated, String comments) {
		super();
		this.issue_key = issue_key;
		this.project_key = project_key;
		this.project_name = project_name;
		this.summary = summary;
		this.labels = labels;
		this.issue_type = issue_type;
		this.assignee = assignee;
		this.description = description;
		this.status = status;
		this.reporter = reporter;
		this.created = created;
		this.updated = updated;
		this.comments = comments;
	}
	public String getIssue_key() {
		return issue_key;
	}
	public void setIssue_key(String issue_key) {
		this.issue_key = issue_key;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	public String getIssue_type() {
		return issue_type;
	}
	public void setIssue_type(String issue_type) {
		this.issue_type = issue_type;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
