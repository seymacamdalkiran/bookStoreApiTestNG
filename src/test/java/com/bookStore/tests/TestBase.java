package com.bookStore.tests;

import com.bookStore.utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class TestBase {
    public static Response response;

    @BeforeMethod
    public void setUp(){
        baseURI= ConfigurationReader.get("baseURI");

    }

}
