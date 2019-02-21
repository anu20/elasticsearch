package org.training.elk;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="jirabugs",type="bugs")
public class JiraBugs {
	@Id
	private String id;
	public JiraBugs() {
		super();
	}
	private String summary;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public JiraBugs(String id, String summary, String status) {
		super();
		this.id = id;
		this.summary = summary;
		this.status = status;
	}
	
}
