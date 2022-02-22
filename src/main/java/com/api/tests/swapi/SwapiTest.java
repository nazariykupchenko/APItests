package com.api.tests.swapi;

import com.api.endpoints.swapi.SwapiEndpoint;
import com.api.models.swapi.PeopleModel;
import org.testng.annotations.Test;

public class SwapiTest {

  SwapiEndpoint swapiEndpoint = new SwapiEndpoint();

  @Test
  public void getMemberTest() {
    swapiEndpoint
        .getMember(1);
  }

  @Test
  public void getMemberNameTest() {
    String name = swapiEndpoint
        .getMember(1)
        .extract()
        .body()
        .as(PeopleModel.class)
        .getName();
    System.out.println(name);
  }
}
