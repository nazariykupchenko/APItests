package com.api.models.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class PeopleModel {

  @JsonProperty("species")
  private List<String> species;
  @JsonProperty("vehicles")
  private List<String> vehicles;
  @JsonProperty("starships")
  private List<String> starships;
  @JsonProperty("films")
  private List<String> films;
  @JsonProperty("created")
  private String created;
  @JsonProperty("edited")
  private String edited;
  @JsonProperty("url")
  private String url;
  @JsonProperty("name")
  private String name;
  @JsonProperty("height")
  private int height;
  @JsonProperty("mass")
  private int mass;
  @JsonProperty("hair_color")
  private String hair_color;
  @JsonProperty("skin_color")
  private String skin_color;
  @JsonProperty("eye_color")
  private String eye_color;
  @JsonProperty("birth_year")
  private String birth_year;
  @JsonProperty("gender")
  private String gender;
  @JsonProperty("homeworld")
  private String homeWorld;
}
