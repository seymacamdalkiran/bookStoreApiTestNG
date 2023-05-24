package com.bookStore.tests.apiTests;

import com.bookStore.tests.DataForApi;
import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBook extends TestBase {

    @Test
    public void deleteBook() {
        String body="{\n" +
                "  \"isbn\": \""+ ConfigurationReader.get("isbn8") +"\",\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\"\n" +
                "}";
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .headers(DataForApi.getBearerToken())
                .when().log().all()
                .delete("BookStore/v1/Book")
                .prettyPeek();
    }

    @Test
    public void verifyDeleting() {
        Assert.assertEquals(response.statusCode(),204);

    }
}
