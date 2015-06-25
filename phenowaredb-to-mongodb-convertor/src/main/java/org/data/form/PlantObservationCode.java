package org.data.form;

public class PlantObservationCode {
	String observationcode;
	int studyid;
	Study study;
	boolean valid;
	public String getObservationcode() {
		return observationcode;
	}
	public void setObservationcode(String observationcode) {
		this.observationcode = observationcode;
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
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
