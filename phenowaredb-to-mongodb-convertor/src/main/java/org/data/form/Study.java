package org.data.form;

import java.util.Date;

public class Study {
	int studyid;
	String name;
	String startdate;
	String enddate;
	String description;
	String keywords;
	int imgfolderid;
	boolean storebinaryimg;
	String binaryimgsubfolder;
	String intranetimgstorename;
	String extranetimgstorename;
	String imgstorelogin;
	String imgstorepassword;

	int status;
	StudyStatus studystatus;
	int ownerid;
	UserInfo userInfo;

	public int getStudyid() {
		return studyid;
	}

	public void setStudyid(int studyid) {
		this.studyid = studyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getImgfolderid() {
		return imgfolderid;
	}

	public void setImgfolderid(int imgfolderid) {
		this.imgfolderid = imgfolderid;
	}

	public boolean isStorebinaryimg() {
		return storebinaryimg;
	}

	public void setStorebinaryimg(boolean storebinaryimg) {
		this.storebinaryimg = storebinaryimg;
	}

	public String getBinaryimgsubfolder() {
		return binaryimgsubfolder;
	}

	public void setBinaryimgsubfolder(String binaryimgsubfolder) {
		this.binaryimgsubfolder = binaryimgsubfolder;
	}

	public String getIntranetimgstorename() {
		return intranetimgstorename;
	}

	public void setIntranetimgstorename(String intranetimgstorename) {
		this.intranetimgstorename = intranetimgstorename;
	}

	public String getExtranetimgstorename() {
		return extranetimgstorename;
	}

	public void setExtranetimgstorename(String extranetimgstorename) {
		this.extranetimgstorename = extranetimgstorename;
	}

	public String getImgstorelogin() {
		return imgstorelogin;
	}

	public void setImgstorelogin(String imgstorelogin) {
		this.imgstorelogin = imgstorelogin;
	}

	public String getImgstorepassword() {
		return imgstorepassword;
	}

	public void setImgstorepassword(String imgstorepassword) {
		this.imgstorepassword = imgstorepassword;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public StudyStatus getStudystatus() {
		return studystatus;
	}

	public void setStudystatus(StudyStatus studystatus) {
		this.studystatus = studystatus;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
