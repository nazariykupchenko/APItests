package com.api.tests.swapi;

import com.api.endpoints.swapi.SwapiUserEndpoint;
import com.api.models.swapi.PeopleModel;
import org.testng.annotations.Test;

public class SwapiUserTest {

  SwapiUserEndpoint swapiUserEndpoint = new SwapiUserEndpoint();

  @Test
  public void getUserTest() {
    swapiUserEndpoint
        .getUser(1);
  }

  @Test
  public void getUserNameTest() {
    String name = swapiUserEndpoint
        .getUser(1)
        .extract()
        .body()
        .as(PeopleModel.class)
        .getName();
    System.out.println(name);
  }
}
