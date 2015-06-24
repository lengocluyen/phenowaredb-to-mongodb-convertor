package org.data.form;

public class Task {
	int id;
	String scheduledstartdate;
	String validity;
	int studyid;
	
	Study study;
	
	String realstartdate;
	String realenddate;
	int ownerid;
	UserInfo userinfo;
	int tasktypeid;
	TaskType taskType;
	
	int status;
	StudyStatus studyStatus;
	String creationdate;
	int tagid;
	Tag tag;
	
	String duration;
	int lanes;
	int stations;
	int profileid;
	
	public int getTasktypeid() {
		return tasktypeid;
	}
	public void setTasktypeid(int tasktypeid) {
		this.tasktypeid = tasktypeid;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	String csvcreationdate;
	String target;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScheduledstartdate() {
		return scheduledstartdate;
	}
	public void setScheduledstartdate(String scheduledstartdate) {
		this.scheduledstartdate = scheduledstartdate;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public int getStudyid() {
		return studyid;
	}
	public void setStudyid(int studyid) {
		this.studyid = studyid;
	}
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public String getRealstartdate() {
		return realstartdate;
	}
	public void setRealstartdate(String realstartdate) {
		this.realstartdate = realstartdate;
	}
	public String getRealenddate() {
		return realenddate;
	}
	public void setRealenddate(String realenddate) {
		this.realenddate = realenddate;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public StudyStatus getStudyStatus() {
		return studyStatus;
	}
	public void setStudyStatus(StudyStatus studyStatus) {
		this.studyStatus = studyStatus;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public int getTagid() {
		return tagid;
	}
	public void setTagid(int tagid) {
		this.tagid = tagid;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getLanes() {
		return lanes;
	}
	public void setLanes(int lanes) {
		this.lanes = lanes;
	}
	public int getStations() {
		return stations;
	}
	public void setStations(int stations) {
		this.stations = stations;
	}
	public int getProfileid() {
		return profileid;
	}
	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}
	public String getCsvcreationdate() {
		return csvcreationdate;
	}
	public void setCsvcreationdate(String csvcreationdate) {
		this.csvcreationdate = csvcreationdate;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
}
