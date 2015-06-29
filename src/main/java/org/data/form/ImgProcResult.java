package org.data.form;

public class ImgProcResult {
	int resultid;
	String studyname;
	int taskid;
	String tagname;
	int plantid;
	String resultdate;
	long timeStampResult;
	boolean valid;
	boolean offlineprocessing;
	String imgprocprofilename;
	ImgProcProfile imagProcProfile;
	String imgguid;
	String rootpath;
	String xscale;
	String yscale;
	int parallelboundingbox_x;
	int parallelboundingbox_y;
	int parallelboundingbox_width;
	int parallelboundingbox_height;
	int parallelboundingbox_area;
	double nonparallelboundingbox_x;
	double nonparallelboundingbox_y;
	double nonparallelboundingbox_width;
	double nonparallelboundingbox_height;
	double nonparallelboundingbox_area;
	double nonparallelboundingbox_teta;
	int height;
	double centerofmassx;
	double centerofmassy;
	int area_color_1;
	int area_color_2;
	double fitellipse_x;
	double fitellipse_y;
	double fitellipse_width;
	double fitellipse_height;
	double fitellipse_teta;
	double fitellipse_area;
	double minenclosingcircle_x;
	double minenclosingcircle_y;
	double minenclosingcircle_area;
	String convexhull;
	String   binaryimgguid;
	int lane;
	int rank;
	int level;
	String subfolder;
	String binarysubfolder;
	String unitscale;
	double minenclosingcircle_radius;
	String acquisitiondate;
	
	
	public long getTimeStampResult() {
		return timeStampResult;
	}
	public void setTimeStampResult(long timeStampResult) {
		this.timeStampResult = timeStampResult;
	}
	public ImgProcProfile getImagProcProfile() {
		return imagProcProfile;
	}
	public void setImagProcProfile(ImgProcProfile imagProcProfile) {
		this.imagProcProfile = imagProcProfile;
	}
	public int getResultid() {
		return resultid;
	}
	public void setResultid(int resultid) {
		this.resultid = resultid;
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
	public boolean isOfflineprocessing() {
		return offlineprocessing;
	}
	public void setOfflineprocessing(boolean offlineprocessing) {
		this.offlineprocessing = offlineprocessing;
	}
	public String getImgprocprofilename() {
		return imgprocprofilename;
	}
	public void setImgprocprofilename(String imgprocprofilename) {
		this.imgprocprofilename = imgprocprofilename;
	}
	public String getImgguid() {
		return imgguid;
	}
	public void setImgguid(String imgguid) {
		this.imgguid = imgguid;
	}
	public String getRootpath() {
		return rootpath;
	}
	public void setRootpath(String rootpath) {
		this.rootpath = rootpath;
	}
	public String getXscale() {
		return xscale;
	}
	public void setXscale(String xscale) {
		this.xscale = xscale;
	}
	public String getYscale() {
		return yscale;
	}
	public void setYscale(String yscale) {
		this.yscale = yscale;
	}
	public int getParallelboundingbox_x() {
		return parallelboundingbox_x;
	}
	public void setParallelboundingbox_x(int parallelboundingbox_x) {
		this.parallelboundingbox_x = parallelboundingbox_x;
	}
	public int getParallelboundingbox_y() {
		return parallelboundingbox_y;
	}
	public void setParallelboundingbox_y(int parallelboundingbox_y) {
		this.parallelboundingbox_y = parallelboundingbox_y;
	}
	public int getParallelboundingbox_width() {
		return parallelboundingbox_width;
	}
	public void setParallelboundingbox_width(int parallelboundingbox_width) {
		this.parallelboundingbox_width = parallelboundingbox_width;
	}
	public int getParallelboundingbox_height() {
		return parallelboundingbox_height;
	}
	public void setParallelboundingbox_height(int parallelboundingbox_height) {
		this.parallelboundingbox_height = parallelboundingbox_height;
	}
	public int getParallelboundingbox_area() {
		return parallelboundingbox_area;
	}
	public void setParallelboundingbox_area(int parallelboundingbox_area) {
		this.parallelboundingbox_area = parallelboundingbox_area;
	}
	public double getNonparallelboundingbox_x() {
		return nonparallelboundingbox_x;
	}
	public void setNonparallelboundingbox_x(double nonparallelboundingbox_x) {
		this.nonparallelboundingbox_x = nonparallelboundingbox_x;
	}
	public double getNonparallelboundingbox_y() {
		return nonparallelboundingbox_y;
	}
	public void setNonparallelboundingbox_y(double nonparallelboundingbox_y) {
		this.nonparallelboundingbox_y = nonparallelboundingbox_y;
	}
	public double getNonparallelboundingbox_width() {
		return nonparallelboundingbox_width;
	}
	public void setNonparallelboundingbox_width(double nonparallelboundingbox_width) {
		this.nonparallelboundingbox_width = nonparallelboundingbox_width;
	}
	public double getNonparallelboundingbox_height() {
		return nonparallelboundingbox_height;
	}
	public void setNonparallelboundingbox_height(
			double nonparallelboundingbox_height) {
		this.nonparallelboundingbox_height = nonparallelboundingbox_height;
	}
	public double getNonparallelboundingbox_area() {
		return nonparallelboundingbox_area;
	}
	public void setNonparallelboundingbox_area(double nonparallelboundingbox_area) {
		this.nonparallelboundingbox_area = nonparallelboundingbox_area;
	}
	public double getNonparallelboundingbox_teta() {
		return nonparallelboundingbox_teta;
	}
	public void setNonparallelboundingbox_teta(double nonparallelboundingbox_teta) {
		this.nonparallelboundingbox_teta = nonparallelboundingbox_teta;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getCenterofmassx() {
		return centerofmassx;
	}
	public void setCenterofmassx(double centerofmassx) {
		this.centerofmassx = centerofmassx;
	}
	public double getCenterofmassy() {
		return centerofmassy;
	}
	public void setCenterofmassy(double centerofmassy) {
		this.centerofmassy = centerofmassy;
	}
	public int getArea_color_1() {
		return area_color_1;
	}
	public void setArea_color_1(int area_color_1) {
		this.area_color_1 = area_color_1;
	}
	public int getArea_color_2() {
		return area_color_2;
	}
	public void setArea_color_2(int area_color_2) {
		this.area_color_2 = area_color_2;
	}
	public double getFitellipse_x() {
		return fitellipse_x;
	}
	public void setFitellipse_x(double fitellipse_x) {
		this.fitellipse_x = fitellipse_x;
	}
	public double getFitellipse_y() {
		return fitellipse_y;
	}
	public void setFitellipse_y(double fitellipse_y) {
		this.fitellipse_y = fitellipse_y;
	}
	public double getFitellipse_width() {
		return fitellipse_width;
	}
	public void setFitellipse_width(double fitellipse_width) {
		this.fitellipse_width = fitellipse_width;
	}
	public double getFitellipse_height() {
		return fitellipse_height;
	}
	public void setFitellipse_height(double fitellipse_height) {
		this.fitellipse_height = fitellipse_height;
	}
	public double getFitellipse_teta() {
		return fitellipse_teta;
	}
	public void setFitellipse_teta(double fitellipse_teta) {
		this.fitellipse_teta = fitellipse_teta;
	}
	public double getFitellipse_area() {
		return fitellipse_area;
	}
	public void setFitellipse_area(double fitellipse_area) {
		this.fitellipse_area = fitellipse_area;
	}
	public double getMinenclosingcircle_x() {
		return minenclosingcircle_x;
	}
	public void setMinenclosingcircle_x(double minenclosingcircle_x) {
		this.minenclosingcircle_x = minenclosingcircle_x;
	}
	public double getMinenclosingcircle_y() {
		return minenclosingcircle_y;
	}
	public void setMinenclosingcircle_y(double minenclosingcircle_y) {
		this.minenclosingcircle_y = minenclosingcircle_y;
	}
	public double getMinenclosingcircle_area() {
		return minenclosingcircle_area;
	}
	public void setMinenclosingcircle_area(double minenclosingcircle_area) {
		this.minenclosingcircle_area = minenclosingcircle_area;
	}
	public String getConvexhull() {
		return convexhull;
	}
	public void setConvexhull(String convexhull) {
		this.convexhull = convexhull;
	}
	public String getBinaryimgguid() {
		return binaryimgguid;
	}
	public void setBinaryimgguid(String binaryimgguid) {
		this.binaryimgguid = binaryimgguid;
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
	public String getSubfolder() {
		return subfolder;
	}
	public void setSubfolder(String subfolder) {
		this.subfolder = subfolder;
	}
	public String getBinarysubfolder() {
		return binarysubfolder;
	}
	public void setBinarysubfolder(String binarysubfolder) {
		this.binarysubfolder = binarysubfolder;
	}
	public String getUnitscale() {
		return unitscale;
	}
	public void setUnitscale(String unitscale) {
		this.unitscale = unitscale;
	}
	public double getMinenclosingcircle_radius() {
		return minenclosingcircle_radius;
	}
	public void setMinenclosingcircle_radius(double minenclosingcircle_radius) {
		this.minenclosingcircle_radius = minenclosingcircle_radius;
	}
	public String getAcquisitiondate() {
		return acquisitiondate;
	}
	public void setAcquisitiondate(String acquisitiondate) {
		this.acquisitiondate = acquisitiondate;
	}
	
	
}
