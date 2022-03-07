package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceData {

  @JsonProperty("id")
  private int id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("year")
  private int year;
  @JsonProperty("color")
  private String color;
  @JsonProperty("pantone_value")
  private String pantoneValue;
  @JsonProperty("some_field") //jsonIgnoreProperties
  private String someField;
}
