package com.bookStore.tests.apiTests;

import com.bookStore.tests.DataForApi;
import com.bookStore.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorizedUser extends TestBase {
    @Test
    public void authorizedUser() {
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .body(DataForApi.mapBody())
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("Account/v1/Authorized")
                .prettyPeek();

    }

    @Test
    public void validateAuthorizedUser() {
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.asString(),"true");
        Assert.assertTrue(response.asString().contains("true"));

    }
}
