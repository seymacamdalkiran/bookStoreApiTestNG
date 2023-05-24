package com.bookStore.tests.apiTests;

import com.bookStore.tests.DataForApi;
import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenerateToken extends TestBase {

    @Test
    public void generateToken() {
        response=RestAssured.given()
                .accept(ContentType.JSON)
                .body(DataForApi.mapBody())
                .contentType(ContentType.JSON)
                .post("Account/v1/GenerateToken")
                .prettyPeek();
    }

    @Test
    public void validateGenerateToken() {
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertNotNull(response.path("token"));
        Assert.assertEquals(response.path("result"),"User authorized successfully.");
        Assert.assertEquals(response.path("status"),"Success");

        ConfigurationReader.set("token",response.path("token"));
    }
}
