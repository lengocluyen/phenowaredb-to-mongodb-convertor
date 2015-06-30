package org.data.jsonconvertor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.ImgProcResultDao;
import org.data.form.ImgProcResult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImageAnalysisConvertor {
	public static void ImageAnalysisConvertToJson(
			String fileName) {
		// List<LinkedHashMap<String, Object>> jsons = new
		// ArrayList<LinkedHashMap<String, Object>>();
		ImgProcResultDao iprd = new ImgProcResultDao(null);
		//List<ImgProcResult> iprs = iprd.all(false);
		ResultSet rs = iprd.resultSet();
		try {
			FileWriter file = new FileWriter(fileName);
			boolean formated = false;
			while (rs.next()) {
				ImgProcResult ipr = iprd.get(rs);
				LinkedHashMap<String, Object> imageAnalysis = new LinkedHashMap<String, Object>();
				Map<String, Object> configuration = new LinkedHashMap<String, Object>();
				configuration.put("provider", "phenowaredb");
				configuration.put("resultid", ipr.getResultid());
				configuration.put("studyname", ipr.getStudyname());
				configuration.put("taskid", ipr.getTaskid());
				configuration.put("plantid", ipr.getPlantid());
				configuration.put("imgguid", ipr.getImgguid());
				configuration.put("rootpath", ipr.getRootpath());
				configuration.put("subfolder", ipr.getSubfolder());
				configuration.put("binarysubfolder", ipr.getBinarysubfolder());
				Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
				nextLocation.put("lane", ipr.getLane());
				nextLocation.put("rank", ipr.getRank());
				nextLocation.put("level", ipr.getLevel());
				configuration.put("nextLocation", nextLocation);
				imageAnalysis.put("configuration", configuration);
				Map<String, Object> data = new LinkedHashMap<String, Object>();
				Map<String, Object> scale = new LinkedHashMap<String, Object>();
				Map<String, Object> scalex = new LinkedHashMap<String, Object>();
				Map<String, Object> scaley = new LinkedHashMap<String, Object>();
				scalex.put("value", ipr.getXscale());
				scalex.put("unity", "");
				scalex.put("type", "computed");
				scalex.put("confidence", "unspecified");
				scaley.put("value", ipr.getYscale());
				scaley.put("unity", "");
				scaley.put("type", "computed");
				scaley.put("confidence", "unspecified");
				scale.put("x", scalex);
				scale.put("y", scaley);
				data.put("scale", scale);
				Map<String, Object> parallelBoudingBox = new LinkedHashMap<String, Object>();
				Map<String, Object> parallelBoudingBoxx = new LinkedHashMap<String, Object>();
				Map<String, Object> parallelBoudingBoxy = new LinkedHashMap<String, Object>();
				Map<String, Object> parallelBoudingBoxheight = new LinkedHashMap<String, Object>();
				Map<String, Object> parallelBoudingBoxweight = new LinkedHashMap<String, Object>();
				Map<String, Object> parallelBoudingBoxarea = new LinkedHashMap<String, Object>();
				parallelBoudingBoxx
						.put("value", ipr.getParallelboundingbox_x());
				parallelBoudingBoxx.put("unity", "");
				parallelBoudingBoxx.put("type", "computed");
				parallelBoudingBoxx.put("confidence", "unspecified");
				parallelBoudingBoxy
						.put("value", ipr.getParallelboundingbox_y());
				parallelBoudingBoxy.put("unity", "");
				parallelBoudingBoxy.put("type", "computed");
				parallelBoudingBoxy.put("confidence", "unspecified");
				parallelBoudingBoxheight.put("value",
						ipr.getParallelboundingbox_height());
				parallelBoudingBoxheight.put("unity", "");
				parallelBoudingBoxheight.put("type", "computed");
				parallelBoudingBoxheight.put("confidence", "unspecified");
				parallelBoudingBoxweight.put("value",
						ipr.getParallelboundingbox_width());
				parallelBoudingBoxweight.put("unity", "");
				parallelBoudingBoxweight.put("type", "computed");
				parallelBoudingBoxweight.put("confidence", "unspecified");
				parallelBoudingBoxarea.put("value",
						ipr.getParallelboundingbox_area());
				parallelBoudingBoxarea.put("unity", "");
				parallelBoudingBoxarea.put("type", "computed");
				parallelBoudingBoxarea.put("confidence", "unspecified");

				parallelBoudingBox.put("x", parallelBoudingBoxx);
				parallelBoudingBox.put("y", parallelBoudingBoxy);
				parallelBoudingBox.put("height", parallelBoudingBoxheight);
				parallelBoudingBox.put("width", parallelBoudingBoxweight);
				parallelBoudingBox.put("area", parallelBoudingBoxarea);
				data.put("parallelBoudingBox", parallelBoudingBox);

				Map<String, Object> nonParallelBoudingBox = new LinkedHashMap<String, Object>();
				Map<String, Object> nonParallelBoudingBoxx = new LinkedHashMap<String, Object>();
				Map<String, Object> nonParallelBoudingBoxy = new LinkedHashMap<String, Object>();
				Map<String, Object> nonParallelBoudingBoxheight = new LinkedHashMap<String, Object>();
				Map<String, Object> nonParallelBoudingBoxweight = new LinkedHashMap<String, Object>();
				Map<String, Object> nonParallelBoudingBoxarea = new LinkedHashMap<String, Object>();
				Map<String, Object> nonParallelBoudingBoxteta = new LinkedHashMap<String, Object>();

				nonParallelBoudingBoxx.put("value",
						ipr.getNonparallelboundingbox_x());
				nonParallelBoudingBoxx.put("unity", "");
				nonParallelBoudingBoxx.put("type", "computed");
				nonParallelBoudingBoxx.put("confidence", "unspecified");
				nonParallelBoudingBoxy.put("value",
						ipr.getNonparallelboundingbox_y());
				nonParallelBoudingBoxy.put("unity", "");
				nonParallelBoudingBoxy.put("type", "computed");
				nonParallelBoudingBoxy.put("confidence", "unspecified");
				nonParallelBoudingBoxheight.put("value",
						ipr.getNonparallelboundingbox_height());
				nonParallelBoudingBoxheight.put("unity", "");
				nonParallelBoudingBoxheight.put("type", "computed");
				nonParallelBoudingBoxheight.put("confidence", "unspecified");
				nonParallelBoudingBoxweight.put("value",
						ipr.getNonparallelboundingbox_width());
				nonParallelBoudingBoxweight.put("unity", "");
				nonParallelBoudingBoxweight.put("type", "computed");
				nonParallelBoudingBoxweight.put("confidence", "unspecified");
				nonParallelBoudingBoxarea.put("value",
						ipr.getNonparallelboundingbox_area());
				nonParallelBoudingBoxarea.put("unity", "");
				nonParallelBoudingBoxarea.put("type", "computed");
				nonParallelBoudingBoxarea.put("confidence", "unspecified");
				nonParallelBoudingBoxteta.put("value",
						ipr.getNonparallelboundingbox_teta());
				nonParallelBoudingBoxteta.put("unity", "");
				nonParallelBoudingBoxteta.put("type", "computed");
				nonParallelBoudingBoxteta.put("confidence", "unspecified");

				nonParallelBoudingBox.put("x", nonParallelBoudingBoxx);
				nonParallelBoudingBox.put("y", nonParallelBoudingBoxy);
				nonParallelBoudingBox
						.put("height", nonParallelBoudingBoxheight);
				nonParallelBoudingBox.put("width", nonParallelBoudingBoxweight);
				nonParallelBoudingBox.put("area", nonParallelBoudingBoxarea);
				nonParallelBoudingBox.put("teta", nonParallelBoudingBoxteta);

				data.put("nonParallelBoudingBox", nonParallelBoudingBox);

				Map<String, Object> centerofmass = new LinkedHashMap<String, Object>();
				Map<String, Object> centerofmassx = new LinkedHashMap<String, Object>();
				Map<String, Object> centerofmassy = new LinkedHashMap<String, Object>();
				centerofmassx.put("value", ipr.getCenterofmassx());
				centerofmassx.put("unity", "");
				centerofmassx.put("type", "computed");
				centerofmassx.put("confidence", "unspecified");
				centerofmassy.put("value", ipr.getCenterofmassy());
				centerofmassy.put("unity", "");
				centerofmassy.put("type", "computed");
				centerofmassy.put("confidence", "unspecified");
				centerofmass.put("x", centerofmassx);
				centerofmass.put("y", centerofmassy);
				data.put("centerofmass", centerofmass);

				Map<String, Object> area_color = new LinkedHashMap<String, Object>();
				Map<String, Object> area_color1 = new LinkedHashMap<String, Object>();
				Map<String, Object> area_color2 = new LinkedHashMap<String, Object>();
				area_color1.put("value", ipr.getArea_color_1());
				area_color1.put("unity", "");
				area_color1.put("type", "computed");
				area_color1.put("confidence", "unspecified");
				area_color2.put("value", ipr.getArea_color_2());
				area_color2.put("unity", "");
				area_color2.put("type", "computed");
				area_color2.put("confidence", "unspecified");
				area_color.put("color_1", area_color1);
				area_color.put("color_2", area_color2);
				data.put("area_color", area_color);

				Map<String, Object> fitellipse = new LinkedHashMap<String, Object>();
				Map<String, Object> fitellipsex = new LinkedHashMap<String, Object>();
				Map<String, Object> fitellipsey = new LinkedHashMap<String, Object>();
				Map<String, Object> fitellipseheight = new LinkedHashMap<String, Object>();
				Map<String, Object> fitellipseweight = new LinkedHashMap<String, Object>();
				Map<String, Object> fitellipsearea = new LinkedHashMap<String, Object>();
				Map<String, Object> fitellipseteta = new LinkedHashMap<String, Object>();

				fitellipsex.put("value", ipr.getFitellipse_x());
				fitellipsex.put("unity", "");
				fitellipsex.put("type", "computed");
				fitellipsex.put("confidence", "unspecified");
				fitellipsey.put("value", ipr.getFitellipse_y());
				fitellipsey.put("unity", "");
				fitellipsey.put("type", "computed");
				fitellipsey.put("confidence", "unspecified");
				fitellipseheight.put("value", ipr.getFitellipse_height());
				fitellipseheight.put("unity", "");
				fitellipseheight.put("type", "computed");
				fitellipseheight.put("confidence", "unspecified");
				fitellipseweight.put("value", ipr.getFitellipse_width());
				fitellipseweight.put("unity", "");
				fitellipseweight.put("type", "computed");
				fitellipseweight.put("confidence", "unspecified");
				fitellipsearea.put("value", ipr.getFitellipse_area());
				fitellipsearea.put("unity", "");
				fitellipsearea.put("type", "computed");
				fitellipsearea.put("confidence", "unspecified");
				fitellipseteta.put("value", ipr.getFitellipse_teta());
				fitellipseteta.put("unity", "");
				fitellipseteta.put("type", "computed");
				fitellipseteta.put("confidence", "unspecified");

				fitellipse.put("x", fitellipsex);
				fitellipse.put("y", fitellipsey);
				fitellipse.put("height", fitellipseheight);
				fitellipse.put("width", fitellipseweight);
				fitellipse.put("area", fitellipsearea);
				fitellipse.put("teta", fitellipseteta);
				data.put("fitellipse", fitellipse);

				Map<String, Object> minenclosingcircle = new LinkedHashMap<String, Object>();
				Map<String, Object> minenclosingcirclex = new LinkedHashMap<String, Object>();
				Map<String, Object> minenclosingcircley = new LinkedHashMap<String, Object>();
				Map<String, Object> minenclosingcirclearea = new LinkedHashMap<String, Object>();
				Map<String, Object> minenclosingcircleradius = new LinkedHashMap<String, Object>();

				minenclosingcirclex.put("value", ipr.getMinenclosingcircle_x());
				minenclosingcirclex.put("unity", "");
				minenclosingcirclex.put("type", "computed");
				minenclosingcirclex.put("confidence", "unspecified");
				minenclosingcircley.put("value", ipr.getMinenclosingcircle_y());
				minenclosingcircley.put("unity", "");
				minenclosingcircley.put("type", "computed");
				minenclosingcircley.put("confidence", "unspecified");
				minenclosingcirclearea.put("value",
						ipr.getMinenclosingcircle_area());
				minenclosingcirclearea.put("unity", "");
				minenclosingcirclearea.put("type", "computed");
				minenclosingcirclearea.put("confidence", "unspecified");
				minenclosingcircleradius.put("value",
						ipr.getMinenclosingcircle_radius());
				minenclosingcircleradius.put("unity", "");
				minenclosingcircleradius.put("type", "computed");
				minenclosingcircleradius.put("confidence", "unspecified");

				minenclosingcircle.put("x", minenclosingcirclex);
				minenclosingcircle.put("y", minenclosingcircley);
				minenclosingcircle.put("area", minenclosingcirclearea);
				minenclosingcircle.put("radius", minenclosingcircleradius);
				data.put("minenclosingcircle", minenclosingcircle);

				Map<String, Object> convexhull = new LinkedHashMap<String, Object>();
				convexhull.put("value", ipr.getConvexhull());
				convexhull.put("unity", "polygon");
				convexhull.put("type", "computed");
				convexhull.put("confidence", "unspecified");
				data.put("convexhull", convexhull);

				Map<String, Object> height = new LinkedHashMap<String, Object>();
				height.put("value", ipr.getHeight());
				height.put("unity", "polygon");
				height.put("type", "computed");
				height.put("confidence", "unspecified");
				data.put("height", height);

				imageAnalysis.put("data", data);
				imageAnalysis.put("binaryImageName", ipr.getBinaryimgguid());
				imageAnalysis.put("binaryImagePath", ipr.getBinaryimgguid());
				imageAnalysis.put("userValidation", ipr.isValid());
				imageAnalysis.put("isReprocessing", ipr.isOfflineprocessing());
				imageAnalysis.put("unitscale", ipr.getUnitscale());
				imageAnalysis.put(
						"imageAnalysisProccessing",
						ipr.getImagProcProfile() == null ? ipr
								.getImgprocprofilename() : ipr
								.getImagProcProfile().getImgProcProfileId());
				imageAnalysis.put("imageAcquisitionDate",
						ipr.getAcquisitiondate());
				imageAnalysis.put("imageAnalysisDate", ipr.getResultdate());
				imageAnalysis.put("imageAnalysisTimestamp",
						ipr.getTimeStampResult());
			
				// jsons.add(imageAnalysis);

				String jsonString = new org.json.JSONObject(imageAnalysis)
						.toString();
				// file.write("Document json "+i+"\n");

				if (formated)
					file.write(Utils.prettyJsonFormat(jsonString) + "\n");
				else
					file.write(jsonString + "\n");
				// System.out.println("Writing the document " + i+": " +
				// jsonString);

				file.flush();

			}

			System.out.println("Finish");
			file.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		// return jsons;
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ExportToFile(String filename) {
		ImageAnalysisConvertToJson(filename);
		//List<LinkedHashMap<String, Object>> jsons3 = ImageAnalysisConvertToJson(filename);
		// JsonReadWrite jrw3 = new JsonReadWrite();
		// jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ExportToFile("Data/ImageAnalysis2.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
