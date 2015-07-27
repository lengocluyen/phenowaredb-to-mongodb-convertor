package org.data.form;

import org.data.handle.TechnicalPlateau;

public class Image {
	String imgguid;
	int plantid;
	int studyid;
	Study study;
	
	private TechnicalPlateau technicalPlateau = TechnicalPlateau.Phenoarch ; //TODO : A modifier lorsqu'on s'occupera des imgs issues des autres plateaux  
	String fileFormat;
	
	int taskid;
	Task task;
	int tagid;
	Tag tag;
	int imgacqprofileid;
	
	int viewtypeid;
	ImageViewType viewType;
	
	int stationid;
	int rootpathid;
	DirectoryPath rootPath;
	
	boolean valid;
	int imgangle;
	String subfolder;
	String acquisitiondate;
	long timestamps;
	int imgid;
	int lane;
	int rank;
	int level;
	boolean refimage;
	
	
	public long getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(long timestamps) {
		this.timestamps = timestamps;
	}
	public String getImgguid() {
		return imgguid;
	}
	public void setImgguid(String imgguid) {
		this.imgguid = imgguid;
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
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public TechnicalPlateau getTechnicalPlateau() {
		return technicalPlateau;
	}
	public void setTechnicalPlateau(TechnicalPlateau technicalPlateau) {
		this.technicalPlateau = technicalPlateau;
	}
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public void setFileFormat(){
		if(this.getTechnicalPlateau() == TechnicalPlateau.Phenoarch)
			this.fileFormat = ".png";
		else
			this.fileFormat = "";  //TODO : modifier pour autres plateaux
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
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
	public int getImgacqprofileid() {
		return imgacqprofileid;
	}
	public void setImgacqprofileid(int imgacqprofileid) {
		this.imgacqprofileid = imgacqprofileid;
	}
	public int getViewtypeid() {
		return viewtypeid;
	}
	public void setViewtypeid(int viewtypeid) {
		this.viewtypeid = viewtypeid;
	}
	public ImageViewType getViewType() {
		return viewType;
	}
	public void setViewType(ImageViewType viewType) {
		this.viewType = viewType;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public int getRootpathid() {
		return rootpathid;
	}
	public void setRootpathid(int rootpathid) {
		this.rootpathid = rootpathid;
	}
	public DirectoryPath getRootPath() {
		return rootPath;
	}
	public void setRootPath(DirectoryPath rootPath) {
		this.rootPath = rootPath;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getImgangle() {
		return imgangle;
	}
	public void setImgangle(int imgangle) {
		this.imgangle = imgangle;
	}
	public String getSubfolder() {
		return subfolder;
	}
	public void setSubfolder(String subfolder) {
		this.subfolder = subfolder;
	}
	public String getAcquisitiondate() {
		return acquisitiondate;
	}
	public void setAcquisitiondate(String acquisitiondate) {
		this.acquisitiondate = acquisitiondate;
	}
	public int getImgid() {
		return imgid;
	}
	public void setImgid(int imgid) {
		this.imgid = imgid;
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
	public boolean isRefimage() {
		return refimage;
	}
	public void setRefimage(boolean refimage) {
		this.refimage = refimage;
	}
	
}
