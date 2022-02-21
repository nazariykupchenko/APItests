package com.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PeopleModel {
  @JsonProperty("name")
  String name;
  @JsonProperty("height")
  int height;
  @JsonProperty("mass")
  int mass;
  @JsonProperty("hair_color")
  String hair_color;
  @JsonProperty("skin_color")
  String skin_color;
  @JsonProperty("eye_color")
  String eye_color;
  @JsonProperty("birth_year")
  String birth_year;
  @JsonProperty("gender")
  String gender;
  @JsonProperty("homeworld")
  String homeworld;
  @JsonProperty("films")
  String[] films;
  @JsonProperty("species")
  String[] species;
  @JsonProperty("vehicles")
  String[] vehicles;
  @JsonProperty("starships")
  String[] starships;
  @JsonProperty("created")
  String created;
  @JsonProperty("edited")
  String edited;
  @JsonProperty("url")
  String url;
}
