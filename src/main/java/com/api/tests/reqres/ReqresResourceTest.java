package com.api.tests.reqres;

import static com.api.utils.Properties.SINGLE_RESOURCE_SCHEMA;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

import com.api.endpoints.reqres.ReqresResourcesEndpoint;
import com.api.models.reqres.ResourceList;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ReqresResourceTest {

  private static final int SINGLE_RESOURCE_SCHEMA_ID = 2;
  private final ReqresResourcesEndpoint reqresResourcesEndpoint = new ReqresResourcesEndpoint();

  @Test
  public void resourceSchemaValidation() {
    reqresResourcesEndpoint.getSingleResource(SINGLE_RESOURCE_SCHEMA_ID).assertThat().body(
        matchesJsonSchemaInClasspath(SINGLE_RESOURCE_SCHEMA).using(
            settings().with().checkedValidation(false)));
  }

  @Test
  public void listResourceTest() {
    int length = reqresResourcesEndpoint
        .getListOfResources()
        .extract()
        .body()
        .as(ResourceList.class)
        .getResourceData().length;
    Assert.assertEquals(6, length);
    log.info("length is {}", length);
  }
}
