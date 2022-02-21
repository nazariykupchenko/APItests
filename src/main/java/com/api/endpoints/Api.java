package com.api.endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
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
        .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
  }

}
