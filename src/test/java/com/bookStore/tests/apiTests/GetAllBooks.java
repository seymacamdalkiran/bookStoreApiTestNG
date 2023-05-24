package com.bookStore.tests.apiTests;

import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllBooks extends TestBase {

    @Test
    public void getAllBooks() {
        response=RestAssured.given()
                .accept(ContentType.JSON)
                .when().log().all()
                .get("BookStore/v1/Books")
                .prettyPeek();
    }

    @Test
    public void verifyAllBooks() {
        Assert.assertEquals(response.statusCode(),200);
        List<String> allISBNs=response.path("books.isbn");
        for (int i = 0; i < allISBNs.size(); i++) {
            ConfigurationReader.set("isbn"+(i+1),allISBNs.get(i));

        }
    }
}
