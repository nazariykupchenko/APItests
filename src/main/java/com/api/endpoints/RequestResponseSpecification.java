package com.api.endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RequestResponseSpecification {

  public RequestSpecification requestSpecification() {
    RestAssured.baseURI = "https://swapi.dev/api";
    return RestAssured
        .given()
        .contentType("application/json")
        .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
  }

}
