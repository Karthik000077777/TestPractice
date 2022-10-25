package practice;

import org.json.simple.JSONObject;

import com.ken.RestAssured.GetExcelData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class pp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONObject json = new JSONObject();
		json.put("path", "booking");
				RestAssured.given()
								.baseUri("https://restful-booker.herokuapp.com/")
								.header("Content-Type", "application/json")
								.body(json.toJSONString())
								.log()
								.all()
							.when()
								.post()
							.then()
								.log()
								.all()
								.statusCode(200);
	}

}
