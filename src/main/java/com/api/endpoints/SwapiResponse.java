package com.api.endpoints;

import io.restassured.response.ValidatableResponse;

public class SwapiResponse extends Api {

  public ValidatableResponse swapiResponse(int i) {
    return requestSpecification()
        .get("people/" + i)
        .then();
  }
}
