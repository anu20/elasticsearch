package org.training.elk;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="jirabugs",type="bugs")
public class Confluence {
	
	@Id
	private String project_key;
	private String project_name;
	private String page_name;
	private String link;
	public Confluence(String project_key, String project_name, String page_name, String link) {
		super();
		this.project_key = project_key;
		this.project_name = project_name;
		this.page_name = page_name;
		this.link = link;
	}
	public Confluence() {
		super();
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
	public String getPage_name() {
		return page_name;
	}
	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
