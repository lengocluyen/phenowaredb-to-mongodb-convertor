package org.data.form;

public class WeighingSetpoint {
	int taskid;
	int plantid;
	int studyid;
	int scaletypeid;
	Study study;
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public int getPlantid() {
		return plantid;
	}
	public void setPlantid(int plantid) {
		this.plantid = plantid;
	}
	public int getStudyid() {
		return studyid;
	}
	public void setStudyid(int studyid) {
		this.studyid = studyid;
	}
	public int getScaletypeid() {
		return scaletypeid;
	}
	public void setScaletypeid(int scaletypeid) {
		this.scaletypeid = scaletypeid;
	}
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	
}
