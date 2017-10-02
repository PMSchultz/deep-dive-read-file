package edu.cnm.deepdive.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class File {

  private static final String FILENAME = "largest-product-data.webarchive.txt";

  public static String[] getLines(String filename)
      throws FileNotFoundException, IOException {
    try (
        FileInputStream inStream = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(inStream);
        BufferedReader buffer = new BufferedReader(reader);
    ) {
      List<String> lines = new LinkedList<>();

      for (String line = buffer.readLine();
          line != null;
          line = buffer.readLine()) {
        line = line.trim();
        if (!line.isEmpty()) {
          lines.add(line);
        }
      }
      return lines.toArray(new String[0]);
    }
  }

  //method takes an array of lines, determines number of lines using length
  public static int[][] getMatrix(String[] lines, String delimiter) {
    int[][] data = new int[lines.length][];
    for (int i = 0; i < lines.length; i++) {
      String[] parts = lines[i].split(delimiter);
      int[] row = new int[parts.length];
      for (int j = 0; j < parts.length; j++) {
        row[j] = Integer.parseInt(parts[j]);
      }
      data[i] = row;
    }
    return data;
  }

  //getMatrix is returning and array of arrays
  public static void main(String[] args)
      throws IOException {

    for (int[] row : getMatrix(getLines(FILENAME), "\\s+")) {
      System.out.println(Arrays.toString(row));
    }
  }
}
