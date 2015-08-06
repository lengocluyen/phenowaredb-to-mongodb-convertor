package org.data.handle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
		
//		//TODO rediriger plutot l'output et les erreurs vers un fichier dans le script de lancement
//		File file = new File("Data/logs.txt");
//		FileOutputStream fis;
//		try {
//			fis = new FileOutputStream(file);
//			PrintStream out = new PrintStream(fis);
//			System.setOut(out);
//			//System.setErr(out);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		

		try{
			//Rq : l'ordre de traitement est important (profils, puis imgs, puis analyses)
			
			Date start = new Date();
			ImgAcqCameraProfileConvertor.ImgAcqCameraProfileConvertToJson("Data/ImgCameraProfile.json", false, true);
			Date end = new Date();
			System.out.println(Utils.timePerformance(start, end));
	

			start = new Date();
			ImgAcqStationProfileConvertor.ImgAcqStationProfileConvertToJson("Data/ImgStationProfile.json",false,true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
		
			
			start = new Date();
			ImageConvertor.ImagesConvertToJson("Data/Image.json",false, true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			
			start = new Date();
			ImageAnalysisProcessingConvertor.ImageAnalysisProcessingConvertToJson(
					"Data/ImageAnalysisProcessing.json",false,true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
			
			start = new Date();
			ImageAnalysisConvertor.ImageAnalysisConvertToJson("Data/ImageAnalysis.json",false, true);
			end = new Date();
			System.out.println(Utils.timePerformance(start, end));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		//Waterings et Weighings sont independants des données Images,
		//les insertions peuvent dc se faire meme s'il y a eu des exceptions
		//pour les images
		try{
			Date start = new Date();
			WateringConvertor.WateringResultConvertToJson("Data/Watering2.json", false, true);
			Date end = new Date();
			System.out.println(Utils.timePerformance(start, end));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			Date start = new Date();
			WeighingConvertor.WeighingResultConvertToJson("Data/Weighing2.json", false, true);
			Date end = new Date();
			System.out.println(Utils.timePerformance(start, end));	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
