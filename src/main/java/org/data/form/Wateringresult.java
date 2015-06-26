package org.data.form;

import java.sql.Timestamp;

public class Wateringresult {
	private int wateringId;
	private String studyName;
	private int taskId;
	private String tagName;  // necessaire ?
	private int plantId;
	private Timestamp resultDate;

	private boolean valid;
	private boolean success;
	private int calibration;
	
	private int lane;
	private int rank;
	private int level;

	//"requiredConfig" : 
	private String requiredProduct;
	private String requiredScaleType;
	private String requiredPumpType;
	private int requiredTargetWeight;
	private int requiredTargetQuantity;
	private int requiredPumpSpeed;
	private int requiredMaxQuantity;
	private int requiredMinWeight;
	private boolean requiredMovePerch;

	//"usedConfig" :
	private int usedStationId;
	private int usedScaleId;    //S'il y a plusieurs balances sur une station
	private int usedPumpId;      //S'il y a plusieurs pompes sur une station
	private String usedProduct;
	private String usedScaleType;
	private String usedPumpType;
	private int usedPumpSpeed;


	private int weightBefore;
	private int weightAfter;
	//private int productAmount;  //on pourrait faire weightafter - weightbefore * densite volumique produit ou qqch comme ça
	    
	public Wateringresult(){}
	    
		public int getWateringId() {
			return wateringId;
		}
		public void setWateringId(int wateringId) {
			this.wateringId = wateringId;
		}
		public String getStudyName() {
			return studyName;
		}
		public void setStudyName(String studyName) {
			this.studyName = studyName;
		}
		public int getTaskId() {
			return taskId;
		}
		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}
		public String getTagName() {
			return tagName;
		}
		public void setTagName(String tagName) {
			this.tagName = tagName;
		}
		public int getPlantId() {
			return plantId;
		}
		public void setPlantId(int plantId) {
			this.plantId = plantId;
		}
		public Timestamp getResultDate() {
			return resultDate;
		}
		public void setResultDate(Timestamp resultDate) {
			this.resultDate = resultDate;
		}
		public boolean isValid() {
			return valid;
		}
		public void setValid(boolean valid) {
			this.valid = valid;
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public int getCalibration() {
			return calibration;
		}
		public void setCalibration(int calibration) {
			this.calibration = calibration;
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

		public String getRequiredProduct() {
			return requiredProduct;
		}
		public void setRequiredProduct(String requiredProduct) {
			this.requiredProduct = requiredProduct;
		}
		public String getRequiredScaleType() {
			return requiredScaleType;
		}
		public void setRequiredScaleType(String requiredScaleType) {
			this.requiredScaleType = requiredScaleType;
		}
		public String getRequiredPumpType() {
			return requiredPumpType;
		}
		public void setRequiredPumpType(String requiredPumpType) {
			this.requiredPumpType = requiredPumpType;
		}
		public int getRequiredTargetWeight() {
			return requiredTargetWeight;
		}
		public void setRequiredTargetWeight(int requiredTargetWeight) {
			this.requiredTargetWeight = requiredTargetWeight;
		}
		public int getRequiredTargetQuantity() {
			return requiredTargetQuantity;
		}
		public void setRequiredTargetQuantity(int requiredTargetQuantity) {
			this.requiredTargetQuantity = requiredTargetQuantity;
		}
		public int getRequiredPumpSpeed() {
			return requiredPumpSpeed;
		}
		public void setRequiredPumpSpeed(int requiredPumpSpeed) {
			this.requiredPumpSpeed = requiredPumpSpeed;
		}
		public int getRequiredMaxQuantity() {
			return requiredMaxQuantity;
		}
		public void setRequiredMaxQuantity(int requiredMaxQuantity) {
			this.requiredMaxQuantity = requiredMaxQuantity;
		}
		public int getRequiredMinWeight() {
			return requiredMinWeight;
		}
		public void setRequiredMinWeight(int requiredMinWeight) {
			this.requiredMinWeight = requiredMinWeight;
		}
		public boolean isRequiredMovePerch() {
			return requiredMovePerch;
		}
		public void setRequiredMovePerch(boolean requiredMovePerch) {
			this.requiredMovePerch = requiredMovePerch;
		}
		
		public String getUsedProduct() {
			return usedProduct;
		}
		public void setUsedProduct(String usedProduct) {
			this.usedProduct = usedProduct;
		}
		public String getUsedScaleType() {
			return usedScaleType;
		}
		public void setUsedScaleType(String usedScaleType) {
			this.usedScaleType = usedScaleType;
		}
		public String getUsedPumpType() {
			return usedPumpType;
		}
		public void setUsedPumpType(String usedPumpType) {
			this.usedPumpType = usedPumpType;
		}
		public int getUsedPumpSpeed() {
			return usedPumpSpeed;
		}
		public void setUsedPumpSpeed(int usedPumpSpeed) {
			this.usedPumpSpeed = usedPumpSpeed;
		}
		public int getWeightBefore() {
			return weightBefore;
		}
		public void setWeightBefore(int weightBefore) {
			this.weightBefore = weightBefore;
		}
		public int getWeightAfter() {
			return weightAfter;
		}
		public void setWeightAfter(int weightAfter) {
			this.weightAfter = weightAfter;
		}
//		public int getProductAmount() {
//			return productAmount;
//		}
//		public void setProductAmount(int productAmount) {
//			this.productAmount = productAmount;
//		}
		public int getUsedStationId() {
			return usedStationId;
		}
		public void setUsedStationId(int stationId) {
			this.usedStationId = stationId;
		}
		public int getUsedScaleId() {
			return usedScaleId;
		}
		public void setUsedScaleId(int usedScaleId) {
			this.usedScaleId = usedScaleId;
		}
		public int getUsedPumpId() {
			return usedPumpId;
		}
		public void setUsedPumpId(int usedPumpId) {
			this.usedPumpId = usedPumpId;
		}
	    
	    
}
