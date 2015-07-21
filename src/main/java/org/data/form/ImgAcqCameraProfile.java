package org.data.form;

import org.data.handle.TechnicalPlateau;


public class ImgAcqCameraProfile {
	private TechnicalPlateau technicalPlateau = TechnicalPlateau.Phenoarch ; //TODO : A modifier lorsqu'on s'occupera des imgs issues des autres plateaux  
	
	int imgacqcameraprofileid;
	String imgacqcameraprofilename;
	boolean validated;
	boolean deleted;
	int profiletype;
	ProfileType profileTypeObject;
	
	String description;
	int imageryusertype;

	int interfaceacqtype;
	int viewtype;
	ImageViewType imageViewType;
	int stationid;
	int width;
	int height;
	int triggermode;
	int shutter;
	int gain;
	int brightness;
	int hue;
	int gamma;
	int saturation;
	int sharpness;
	int whitebalance;
	int viewcount;
	String pixelformat;
	String mode;
	
	public ImgAcqCameraProfile(){}
	
	public TechnicalPlateau getTechnicalPlateau() {
		return technicalPlateau;
	}
	public void setTechnicalPlateau(TechnicalPlateau technicalPlateau) {
		this.technicalPlateau = technicalPlateau;
	}	
	public ImageViewType getImageViewType() {
		return imageViewType;
	}
	public void setImageViewType(ImageViewType imageViewType) {
		this.imageViewType = imageViewType;
	}
	public ProfileType getProfileTypeObject() {
		return profileTypeObject;
	}
	public void setProfileTypeObject(ProfileType profileTypeObject) {
		this.profileTypeObject = profileTypeObject;
	}
	public int getImgacqcameraprofileid() {
		return imgacqcameraprofileid;
	}
	public void setImgacqcameraprofileid(int imgacqcameraprofileid) {
		this.imgacqcameraprofileid = imgacqcameraprofileid;
	}
	public String getImgacqcameraprofilename() {
		return imgacqcameraprofilename;
	}
	public void setImgacqcameraprofilename(String imgacqcameraprofilename) {
		this.imgacqcameraprofilename = imgacqcameraprofilename;
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
	public int getInterfaceacqtype() {
		return interfaceacqtype;
	}
	public void setInterfaceacqtype(int interfaceacqtype) {
		this.interfaceacqtype = interfaceacqtype;
	}
	public int getViewtype() {
		return viewtype;
	}
	public void setViewtype(int viewtype) {
		this.viewtype = viewtype;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getTriggermode() {
		return triggermode;
	}
	public void setTriggermode(int triggermode) {
		this.triggermode = triggermode;
	}
	public int getShutter() {
		return shutter;
	}
	public void setShutter(int shutter) {
		this.shutter = shutter;
	}
	public int getGain() {
		return gain;
	}
	public void setGain(int gain) {
		this.gain = gain;
	}
	public int getBrightness() {
		return brightness;
	}
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}
	public int getHue() {
		return hue;
	}
	public void setHue(int hue) {
		this.hue = hue;
	}
	public int getGamma() {
		return gamma;
	}
	public void setGamma(int gamma) {
		this.gamma = gamma;
	}
	public int getSaturation() {
		return saturation;
	}
	public void setSaturation(int saturation) {
		this.saturation = saturation;
	}
	public int getSharpness() {
		return sharpness;
	}
	public void setSharpness(int sharpness) {
		this.sharpness = sharpness;
	}
	public int getWhitebalance() {
		return whitebalance;
	}
	public void setWhitebalance(int whitebalance) {
		this.whitebalance = whitebalance;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getPixelformat() {
		return pixelformat;
	}
	public void setPixelformat(String pixelformat) {
		this.pixelformat = pixelformat;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
