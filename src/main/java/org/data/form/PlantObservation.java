package org.data.form;

public class PlantObservation {
	int observationid;
	String studyname;
	int taskid;
	Task taks;
	String tagname;
	int plantid;
	Plant plant;
	Study study;
	String userlogin;
	String resultdate;
	String date;
	long timestamps;
	boolean valid;
	String observationcode;
	String observation;
	int lane;
	int rank;
	int level;
	int setpointsStationid;
	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public Task getTaks() {
		return taks;
	}

	public void setTaks(Task taks) {
		this.taks = taks;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(long timestamps) {
		this.timestamps = timestamps;
	}

	
	public int getSetpointsStationid() {
		return setpointsStationid;
	}

	public void setSetpointsStationid(int setpointsStationid) {
		this.setpointsStationid = setpointsStationid;
	}

	public int getObservationid() {
		return observationid;
	}

	public void setObservationid(int observationid) {
		this.observationid = observationid;
	}

	public String getStudyname() {
		return studyname;
	}

	public void setStudyname(String studyname) {
		this.studyname = studyname;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public int getPlantid() {
		return plantid;
	}

	public void setPlantid(int plantid) {
		this.plantid = plantid;
	}

	public String getUserlogin() {
		return userlogin;
	}

	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}

	public String getResultdate() {
		return resultdate;
	}

	public void setResultdate(String resultdate) {
		this.resultdate = resultdate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getObservationcode() {
		return observationcode;
	}

	public void setObservationcode(String observationcode) {
		this.observationcode = observationcode;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
