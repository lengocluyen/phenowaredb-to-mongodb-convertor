package org.data.handle;

import java.util.Date;

import org.data.jsonconvertor.ImageAnalysisConvertor;
import org.data.jsonconvertor.ImageAnalysisProcessingConvertor;
import org.data.jsonconvertor.ImageConvertor;
import org.data.jsonconvertor.ImgAcqCameraProfileConvertor;
import org.data.jsonconvertor.ImgAcqStationProfileConvertor;
import org.data.jsonconvertor.WateringConvertor;
import org.data.jsonconvertor.WeighingConvertor;

public class Main {

	public static void main(String[] args) {

		try{
			//Rq : l'ordre de traitement est important (profils, puis imgs, puis analyses)
			
			Date start = new Date();
			ImgAcqCameraProfileConvertor.ImgAcqCameraProfileConvertToJson("Data/ImgCameraProfile.json", true);
			Date end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo

			start = new Date();
			ImgAcqStationProfileConvertor.ImgAcqStationProfileConvertToJson("Data/ImgStationProfile.json",true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo
			
			start = new Date();
			ImageConvertor.ImagesConvertToJson("Data/ImgStationProfile.json",true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo
			
			start = new Date();
			ImageAnalysisProcessingConvertor.ImageAnalysisProcessingConvertToJson(
					"Data/ImageAnalysisProcessing.json",true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo
			
			start = new Date();
			ImageAnalysisConvertor.ImageAnalysisConvertToJson("Data/ImageAnalysis.json",true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo
		}
		catch(Exception e){
			e.printStackTrace();
			//TODO : ecrire exceptions dans un fichier log
		}
		
		
		//Waterings et Weighings sont independants des données Images,
		//les insertions peuvent dc se faire meme s'il y a eu des exceptions
		//pour les images
		try{
			Date start = new Date();
			WateringConvertor.WateringResultConvertToJson("Data/Watering2.json", true);
			Date end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo
		}
		catch(Exception e){
			e.printStackTrace();
			//TODO : ecrire exceptions dans un fichier log
		}
		try{
			Date start = new Date();
			WeighingConvertor.WeighingResultConvertToJson("Data/Weighing2.json", true);
			Date end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			//TODO : ajouter insertion/insertions dans mongo
		}
		catch(Exception e){
			e.printStackTrace();
			//TODO : ecrire exceptions dans un fichier log
		}
	}
}
