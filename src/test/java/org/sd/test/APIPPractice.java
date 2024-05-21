package org.sd.test;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIPPractice {

    @Test
    public void getMethodTest(){
        Response response= given()
                .contentType("application/json; charset=utf-8")
                .pathParams("path", "users") //path parameter
                .queryParam("page",2)  //query parameter
                .when()
                .baseUri("https://reqres.in/api")
                .basePath("/{path}")
                .get();
        System.out.println(response.getContentType());
    response.prettyPrint();

       Map<Object, Integer> m1=response.path("data[0]");
       //System.out.println(m1);

        List<Object> l=response.path("data");
        System.out.println(l);
    }
}
