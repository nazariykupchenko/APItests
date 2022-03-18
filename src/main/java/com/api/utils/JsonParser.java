package com.api.utils;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class JsonParser {

  @JsonProperty("$id")
  private String $id;
  @JsonProperty("id")
  private int id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("email")
  private String email;
  @JsonProperty("profilepicture")
  private String profilePicture;
  @JsonProperty("location")
  private String location;
  @JsonProperty("createdat")
  private String createdAt;
  private Map<String, String> map = new HashMap<>();

  @JsonAnySetter
  void setUserData(String key, String value){
    if (key.equals("email")){
      map.put("key", "value");
    }
  }

}
