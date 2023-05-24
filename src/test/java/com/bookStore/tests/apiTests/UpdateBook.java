package com.bookStore.tests.apiTests;

import com.bookStore.tests.DataForApi;
import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateBook extends TestBase {
    @Test
    public void updateBook() {
        String body="{\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn8")+"\"\n" +
                "}";

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("ISBN", ConfigurationReader.get("isbn3"))
                .headers(DataForApi.getBearerToken())
                .body(body)
                .when().log().all()
                .put("BookStore/v1/Books/{ISBN}")
                .prettyPeek();

    }

    @Test
    public void verifyUpdateProcess() {
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.path("userId"),ConfigurationReader.get("userID"));
        Assert.assertTrue(response.path("books.isbn").toString().contains(ConfigurationReader.get("isbn8")));

    }
}
