package org.data.form;

import org.data.handle.TechnicalPlateau;

public class ImgAcqStationProfile {
	
	private TechnicalPlateau technicalPlateau = TechnicalPlateau.Phenoarch ; //TODO : A modifier lorsqu'on s'occupera des imgs issues des autres plateaux  
	
	int imgacqstationprofileid;
	String imgacqstationprofilename;
	boolean validated;
	boolean deleted;
	int profiletype;
	ProfileType profileTypeObject;
	
	String description;
	int imageryusertype;
	
	int stationid;
	int indexer;
	int toplight;
	int sidelight;
	int zoom;
	int focus;
	int aperture;
	String rotationspeed;
	int topviewcount;
	int sideviewcount;
	
	public ImgAcqStationProfile(){}
	
	public TechnicalPlateau getTechnicalPlateau() {
		return technicalPlateau;
	}
	public void setTechnicalPlateau(TechnicalPlateau technicalPlateau) {
		this.technicalPlateau = technicalPlateau;
	}	
	public int getImgacqstationprofileid() {
		return imgacqstationprofileid;
	}
	public void setImgacqstationprofileid(int imgacqstationprofileid) {
		this.imgacqstationprofileid = imgacqstationprofileid;
	}
	public String getImgacqstationprofilename() {
		return imgacqstationprofilename;
	}
	public void setImgacqstationprofilename(String imgacqstationprofilename) {
		this.imgacqstationprofilename = imgacqstationprofilename;
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
	public int getProfiletype() {
		return profiletype;
	}
	public void setProfiletype(int profiletype) {
		this.profiletype = profiletype;
	}
	public ProfileType getProfileTypeObject() {
		return profileTypeObject;
	}
	public void setProfileTypeObject(ProfileType profileTypeObject) {
		this.profileTypeObject = profileTypeObject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getImageryusertype() {
		return imageryusertype;
	}
	public void setImageryusertype(int imageryusertype) {
		this.imageryusertype = imageryusertype;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public int getIndexer() {
		return indexer;
	}
	public void setIndexer(int indexer) {
		this.indexer = indexer;
	}
	public int getToplight() {
		return toplight;
	}
	public void setToplight(int toplight) {
		this.toplight = toplight;
	}
	public int getSidelight() {
		return sidelight;
	}
	public void setSidelight(int sidelight) {
		this.sidelight = sidelight;
	}
	public int getZoom() {
		return zoom;
	}
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	public int getFocus() {
		return focus;
	}
	public void setFocus(int focus) {
		this.focus = focus;
	}
	public int getAperture() {
		return aperture;
	}
	public void setAperture(int aperture) {
		this.aperture = aperture;
	}
	public String getRotationspeed() {
		return rotationspeed;
	}
	public void setRotationspeed(String rotationspeed) {
		this.rotationspeed = rotationspeed;
	}
	public int getTopviewcount() {
		return topviewcount;
	}
	public void setTopviewcount(int topviewcount) {
		this.topviewcount = topviewcount;
	}
	public int getSideviewcount() {
		return sideviewcount;
	}
	public void setSideviewcount(int sideviewcount) {
		this.sideviewcount = sideviewcount;
	}
	
	
}
