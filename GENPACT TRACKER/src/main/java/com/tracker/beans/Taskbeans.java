package com.tracker.beans;

public class Taskbeans {
	private int  empID ;
    private String taskTitle ;
    private String taskDes ;
    private String taskDate;
    private String taskDur ;
    
    
    
    
    
    
    
	public Taskbeans(int empID, String taskTitle, String taskDes, String taskDate, String taskDur) {
		super();
		this.empID = empID;
		this.taskTitle = taskTitle;
		this.taskDes = taskDes;
		this.taskDate = taskDate;
		this.taskDur = taskDur;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDes() {
		return taskDes;
	}
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskDur() {
		return taskDur;
	}
	public void setTaskDur(String taskDur) {
		this.taskDur = taskDur;
	}
    
    
	
}
