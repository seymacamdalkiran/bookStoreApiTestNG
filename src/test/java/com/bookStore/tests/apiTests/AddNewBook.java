package com.bookStore.tests.apiTests;

import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewBook extends TestBase {
    @Test
    public void addNewBookWithString() {
        String bookBody="{\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn5")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+ ConfigurationReader.get("token"))
                .body(bookBody)
                .when().log().all()
                .post("BookStore/v1/Books")
                .prettyPeek();

    }

    @Test
    public void addNewBookWithMap() {
        Map<String,Object> mapBody=new HashMap<>();
        List<Map<String,String>> list=new ArrayList<>();
        Map<String,String> map=new HashMap<>();
        map.put("isbn",ConfigurationReader.get("isbn3"));

        list.add(map);
        mapBody.put("userId",ConfigurationReader.get("userID"));
        mapBody.put("collectionOfIsbns",list);

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+ ConfigurationReader.get("token"))
                .body(mapBody)
                .when().log().all()
                .post("BookStore/v1/Books")
                .prettyPeek();

    }

    @Test
    public void validateAddingBook() {
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertTrue(response.asString().contains(ConfigurationReader.get("isbn5")));

    }
}
