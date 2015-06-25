package org.data.form;

public class ImgProcProfile {
	private int imgProcProfileId;
	private String imgProcProfileName;
	private boolean validated;
	private boolean deleted;
	private int profileType;
	private String description;
	private String imgProcScript;
	
	
	public ImgProcProfile(){}


	public int getImgProcProfileId() {
		return imgProcProfileId;
	}


	public void setImgProcProfileId(int imgProcProfileId) {
		this.imgProcProfileId = imgProcProfileId;
	}


	public String getImgProcProfileName() {
		return imgProcProfileName;
	}


	public void setImgProcProfileName(String imgProcProfileName) {
		this.imgProcProfileName = imgProcProfileName;
	}


	public boolean isValidated() {
		return validated;
	}


	public void setValidated(boolean validated) {
		this.validated = validated;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public int getProfileType() {
		return profileType;
	}


	public void setProfileType(int profileType) {
		this.profileType = profileType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImgProcScript() {
		return imgProcScript;
	}


	public void setImgProcScript(String imgProcScript) {
		this.imgProcScript = imgProcScript;
	}
	
	

}
