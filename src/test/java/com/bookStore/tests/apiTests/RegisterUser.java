package com.bookStore.tests.apiTests;

import com.bookStore.tests.DataForApi;
import com.bookStore.tests.TestBase;
import com.bookStore.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends TestBase {
    Faker faker=new Faker();
    @Test
    public void registerUser() {

      response=  RestAssured.given()
                .accept(ContentType.JSON)
                .body(DataForApi.mapBody())
                .contentType(ContentType.JSON)
                .post("Account/v1/User")
                .prettyPeek();

    }

    @Test
    public void verifyRegisterUser() {
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertNotNull(response.path("userID"));
        Assert.assertEquals(response.path("username"),ConfigurationReader.get("userName"));

        ConfigurationReader.set("userID",response.path("userID"));
    }
}
