package com.api.tests.reqres;

import static com.api.utils.Properties.SINGLE_RESOURCE_SCHEMA;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

import com.api.endpoints.reqres.ReqresResourcesEndpoint;
import com.api.models.reqres.ResourceData;
import com.api.models.reqres.ResourceList;
import com.api.models.reqres.SingleResource;
import com.api.utils.FileManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ReqresResourceTest {

  private static final int SINGLE_RESOURCE_SCHEMA_ID = 2;
  private final ReqresResourcesEndpoint reqresResourcesEndpoint = new ReqresResourcesEndpoint();
  ObjectMapper mapper = new ObjectMapper();

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
        .getResourceData().size();
    Assert.assertEquals(6, length);
    log.info("length is {}", length);
  }

  @Test
  public void verifySingleResourceResponseTest() throws IOException {
    SingleResource actualSingleResource = reqresResourcesEndpoint
        .getSingleResource(2)
        .extract()
        .body()
        .as(SingleResource.class);
    String expectedResult = FileManager.getJsonString(
        "src/main/resources/reqres/single-resource-response.json");
    SingleResource expectedSingleResource = mapper.readValue(expectedResult, SingleResource.class);
    Assert.assertEquals(expectedSingleResource, actualSingleResource);
  }

  @Test
  public void singleResourceDataResponseTest() throws IOException {
    ResourceData actualSingleResourceData = reqresResourcesEndpoint
        .getSingleResource(2)
        .extract()
        .body()
        .jsonPath()
        .getObject("data", ResourceData.class);
    //витягнули стрінгу з файлу
    String expectedResult = FileManager.getJsonString(
        "src/main/resources/reqres/single-resource-response.json");
//    джексон перетворив верхню стрінгу в об'єкт
    SingleResource expectedSingleResource = mapper.readValue(expectedResult, SingleResource.class);
//    витягнули інший об'єкт з попереднього об'єкту
    ResourceData expectedSingleResourceData = expectedSingleResource.getResourceData();
//    джексон перетворив останній об'єкт в Мапу
    Map<String, String> actualSingleResourceDataMap = mapper.convertValue(actualSingleResourceData,
        new TypeReference<Map<String, String>>() {
        });
    Map<String, String> expectedSingleResourceDataMap = mapper.convertValue(
        expectedSingleResourceData,
        new TypeReference<Map<String, String>>() {
        });
//    google goava порівнює дві Мапи
    MapDifference<String, String> difference = Maps.difference(expectedSingleResourceDataMap,
        actualSingleResourceDataMap);
    log.info("different: {}", difference.entriesDiffering().toString());
    log.info("different only left: {}", difference.entriesOnlyOnLeft().toString());
    log.info("different only right: {}", difference.entriesOnlyOnRight().toString());
    Assert.assertEquals(expectedSingleResourceDataMap, actualSingleResourceDataMap);

  }
}
