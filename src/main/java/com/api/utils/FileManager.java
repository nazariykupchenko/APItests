package com.api.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FileManager {

  public static String getJsonString(String path) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(path));
    String currentLine = reader.lines().collect(Collectors.joining());
    reader.close();
    return currentLine;
  }
}
