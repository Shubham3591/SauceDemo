package org.sd.test.PracticeTC;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIPPractice {

    @Test
    public void getMethodTest() {
        Response response = given()
                //.contentType("application/json; charset=utf-8")
                //.pathParams("path", "users") //path parameter
                //.queryParam("page", 2)  //query parameter
                .when()
                .baseUri("https://jsonplaceholder.typicode.com/users")
                //.basePath("/{path}")
                .get();


        UsersResponse.User[] usersArr = response.as(UsersResponse.User[].class);
        System.out.println("Users length: " + (usersArr != null ? usersArr.length : -1));
        System.out.println("First username (should be Bret): " + usersArr[0].getUsername());



        //System.out.println(users123);                   // Antonette
       // System.out.println(users123.getPhone());

        //System.out.println(response.getContentType());
        //response.prettyPrint();

        //First data
        //Map<Object, Integer> m1 = response.path("");
       // System.out.println("m1"+m1);


        // All data
        List<Object> l = response.path("");
        //Dynamic Response -https://www.youtube.com/watch?v=3YkQv87DsEo
        Object responseAsObject =response.as(Object.class);
        if (responseAsObject instanceof List)
        {
            List responseAsList= (List) responseAsObject;
            System.out.println("List : "+responseAsList.size());
        }
        else {
            Map responseAsMap =(Map) responseAsObject;
        }


        JsonPath jp = response.jsonPath();

        int id = jp.getInt("find { it.username == 'Antonette' }.id");
        System.out.println(id);


        String companyName = jp.getString("[1].company.name");
        System.out.println(companyName);


        List<Map<String, Object>> users = jp.getList("$");

        int id1 = -1;

        for (Map<String, Object> user : users) {
            if ("Antonette".equals(user.get("username"))) {
                id1 = (int) user.get("id");
                break;
            }
        }

        System.out.println("ID: " + id1);

        Map<String, Object> user2 = jp.getMap("find { it.id == 2 }");

        String phone   = (String) user2.get("phone");
        String website = (String) user2.get("website");
        String company1 = (String) ((Map<String, Object>) user2.get("company")).get("name");


        Map<String, Object> company =
                (Map<String, Object>) user2.get("company");

// ✅ Extract all company fields
        String companyName1  = (String) company.get("name");
        String catchPhrase  = (String) company.get("catchPhrase");
        String bs           = (String) company.get("bs");


        System.out.println(company);



        System.out.printf("phone=%s, website=%s, company=%s%n", phone, website, company1);


    }
}
