package com.bookStore.tests.apiTests;

import com.bookStore.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class SetApiData {
    Faker faker=new Faker();

    @Test
    public void setData() {
        ConfigurationReader.set("userName",faker.name().fullName());
        ConfigurationReader.set("password","Sc1*"+faker.internet().password());
        ConfigurationReader.set("baseURI","https://bookstore.toolsqa.com");

    }
}
