package com.earthquake;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Earthquake {
	static int limit;
	
	public static void main(String[] args) {
							
//		Response response1 =
//		RestAssured.given()
//						.baseUri("https://earthquake.usgs.gov/")
//						.basePath("fdsnws/event/1/count")
//						.queryParam("format","geojson")
//						.queryParam("starttime","2015-08-01")
//						.queryParam("endtime","2022-08-16")
//						.queryParam("latitude","18")
//						.queryParam("longitude","73")
//						.queryParam("maxradiuskm","200")
//						.queryParam("orderby", "magnitude-asc")
//						.contentType("application/geojson")
//						.accept("application/geojson")
//						.log()
//						.all()
//					.when()
//						.get();
//			response1.then()
//						.log()
//						.all();
//		
//			limit = response1.jsonPath().getInt("count");
		
		while(true) {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now();  
			   String date = dtf.format(now);  
//			   System.out.println(date);
			   String testTime = "2010-08-01";
			
		AllObjects allobjs = RestAssured.given()
								.baseUri("https://earthquake.usgs.gov/")
								.basePath("fdsnws/event/1/query")
								.queryParam("format","geojson")
								.queryParam("starttime",date)
								.queryParam("endtime",date)
								.queryParam("latitude","18")
								.queryParam("longitude","73")
								.queryParam("maxradiuskm","200")
								.queryParam("orderby", "magnitude-asc")
								.contentType("application/geojson")
								.accept("application/geojson")
//								.log()
//								.all()
							.when()
								.get().as(AllObjects.class);

//				String  type = allobjs.getType();
//				System.out.println(type);
				String ss = allobjs.getMetadata().getCount();
				int count = Integer.valueOf(ss);
//				System.out.println(allobjs.getMetadata().getCount());
				for(int i=0;i<count;i++) {
					if(allobjs.getFeatures().get(i).getProperties().getMag() != 0 ) {
						int in = allobjs.getFeatures().get(i).getProperties().getMag();
						String time = allobjs.getFeatures().get(i).getProperties().getTime();
						String s3 = allobjs.getFeatures().get(i).getProperties().getPlace();
						String s4 = s3.replace('?','a');
						System.out.println("ALERT!!!  EARTHQUAKE AT "+s4+" OF MAG "+in+" Around "+time);
					}
				}
		}
				
//				for(int i=0;i<limit;i++) {
//				String value1 = response.jsonPath().getJsonObject("features["+i+"].properties.place");
//				System.out.println(value1);
//				}
	}
}
