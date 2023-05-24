package com.bookStore.tests.apiTests;

import com.bookStore.tests.DataForApi;
import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAllBooks extends TestBase {
    @Test
    public void deleteAllBooks() {
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .queryParam("UserId", ConfigurationReader.get("userID"))
                .headers(DataForApi.getBearerToken())
                .delete("BookStore/v1/Books")
                .prettyPeek();
    }

    @Test
    public void verifyDeletingAllBooks() {
        Assert.assertEquals(response.statusCode(),204);

    }
}
