package org.data.form;

public class PlantObservationSetpoint {
	int taskid;
	int plantid;
	int studyid;
	int stationid;
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

	public int getStationid() {
		return stationid;
	}

	public void setStationidd(int scaletypeid) {
		this.stationid = scaletypeid;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}
}
