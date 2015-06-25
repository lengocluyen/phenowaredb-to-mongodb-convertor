package org.data.form;

import java.sql.Timestamp;

public class Weighingresult {
	public Weighingresult() {

	}

	public int getWeighingid() {
		return weighingid;
	}
	
	public void setWeighingid(int weighingid) {
		this.weighingid = weighingid;
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

	public Timestamp getResultdate() {
		return resultdate;
	}

	public void setResultdate(Timestamp resultdate) {
		this.resultdate = resultdate;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getWeighingtype() {
		return weighingtype;
	}

	public void setWeighingtype(String weighingtype) {
		this.weighingtype = weighingtype;
	}

	public String getReqscaletypename() {
		return reqscaletypename;
	}

	public void setReqscaletypename(String reqscaletypename) {
		this.reqscaletypename = reqscaletypename;
	}

	public int getUsedstationid() {
		return usedstationid;
	}

	public void setUsedstationid(int usedstationid) {
		this.usedstationid = usedstationid;
	}

	public int getUsedscaleid() {
		return usedscaleid;
	}

	public void setUsedscaleid(int usedscaleid) {
		this.usedscaleid = usedscaleid;
	}

	public String getUsedscaletypename() {
		return usedscaletypename;
	}

	public void setUsedscaletypename(String usedscaletypename) {
		this.usedscaletypename = usedscaletypename;
	}

	public int getWeighbefore() {
		return weighbefore;
	}

	public void setWeighbefore(int weighbefore) {
		this.weighbefore = weighbefore;
	}

	public int getWeighafter() {
		return weighafter;
	}

	public void setWeighafter(int weighafter) {
		this.weighafter = weighafter;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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
	public int getSetpointscaletype() {
		return setpointscaletype;
	}

	public void setSetpointscaletype(int setpointscaletype) {
		this.setpointscaletype = setpointscaletype;
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

	int weighingid;
	String studyname;
	int taskid;
	String tagname;
	int plantid;
	Timestamp resultdate;
	String date;
	long timestamps;
	boolean valid;
	String weighingtype;
	String reqscaletypename;
	int usedstationid;
	int usedscaleid;
	String usedscaletypename;
	int weighbefore;
	int weighafter;
	boolean success;
	int lane;
	int rank;
	int level;
	int setpointscaletype;
	
	

}
