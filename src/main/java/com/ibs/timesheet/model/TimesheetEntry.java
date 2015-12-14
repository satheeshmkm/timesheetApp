package com.ibs.timesheet.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class TimesheetEntry {
	
	@Id
	public String id;
	public String projectCode;
	public String projectName;
	public String projectPhase;
	public String classification;
	public String activity;
	public String bugRef;
	public Date date;
	public String effort;
	public String approvalStatus;
	
	public TimesheetEntry() {

    }

	public TimesheetEntry(String projectCode, String projectName,
			String projectPhase, String classification, String activity,
			String bugRef, Date date, String effort, String approvalStatus) {
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectPhase = projectPhase;
		this.classification = classification;
		this.activity = activity;
		this.bugRef = bugRef;
		this.date = date;
		this.effort = effort;
		this.approvalStatus = approvalStatus;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectPhase() {
		return projectPhase;
	}

	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getBugRef() {
		return bugRef;
	}

	public void setBugRef(String bugRef) {
		this.bugRef = bugRef;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

}
