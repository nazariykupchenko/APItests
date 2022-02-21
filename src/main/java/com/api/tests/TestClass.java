package com.api.tests;

import com.api.endpoints.SwapiResponse;
import com.api.models.PeopleModel;
import org.testng.annotations.Test;

public class TestClass {

  SwapiResponse swapiResponse = new SwapiResponse();
  @Test
  public void swapiFirstTest() {
    swapiResponse.swapiResponse(1);
  }

  @Test
  public void secondTest(){
    String name = swapiResponse.swapiResponse(1)
        .extract().body().as(PeopleModel.class).getName();
    System.out.println(name);
  }
}
