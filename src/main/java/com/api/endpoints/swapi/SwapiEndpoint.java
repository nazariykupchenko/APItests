package com.api.endpoints.swapi;

import static com.api.utils.Properties.PEOPLE_END_POINT;
import static com.api.utils.Properties.SWAPI_BASE_URI;

import com.api.endpoints.Api;
import io.restassured.response.ValidatableResponse;

public class SwapiEndpoint extends Api {

  public ValidatableResponse getMember(int i) {
    return requestSpecification(SWAPI_BASE_URI)
        .get(PEOPLE_END_POINT + i)
        .then()
        .statusCode(200);
  }
}
