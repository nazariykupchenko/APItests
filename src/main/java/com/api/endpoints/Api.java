package com.api.endpoints;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class Api {

  public RequestSpecification requestSpecification(String baseUri) {
    RestAssured.baseURI = baseUri;
    return RestAssured
        .given()
        .header("Content-Type", ContentType.JSON)
        .header("connection", "keep-alive")
        .log()
        .ifValidationFails()
        .filter(new AllureRestAssured()
            .setRequestTemplate("http-request.ftl")
            .setResponseTemplate("http-response.ftl"));
  }
}
