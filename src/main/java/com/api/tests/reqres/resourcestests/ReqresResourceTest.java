package com.api.tests.reqres.resourcestests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

import com.api.endpoints.reqres.ReqresResourcesEndpoint;
import com.api.models.reqres.ResourceList;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ReqresResourceTest {

  private final ReqresResourcesEndpoint reqresResourcesEndpoint = new ReqresResourcesEndpoint();

  @Test
  public void resourceSchemaTest() {
    reqresResourcesEndpoint.getSingleResource(2).assertThat().body(
        matchesJsonSchemaInClasspath("reqres/single-resource-schema.json").using(
            settings().with().checkedValidation(false)));
  }

  @Test
  public void listResourceTest() {
    int length = reqresResourcesEndpoint
        .getListOfResources()
        .extract()
        .body()
        .as(ResourceList.class)
        .getDataList().length;
    Assert.assertEquals(6, length);
    log.info("length is {}" + length);
  }
}
