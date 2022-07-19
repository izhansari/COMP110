package comp110.support;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

  private BufferedReader file;

  public TextFileReader(String path) {
    try {
      file = new BufferedReader(new FileReader(path));
    } catch (FileNotFoundException e) {
      throw new Error("Error reading file, check path");
    }
  }

  public boolean hasNext() {
    try {
      file.mark(2000);
      if (file.readLine() == null) {
        return false;
      } else {
        file.reset();
        return true;
      }
    } catch (IOException e) {
      throw new Error("Error reading file. Make sure the file is UTF compliant.");
    }
  }

  public String next() {
    try {
      return file.readLine();
    } catch (IOException e) {
      throw new Error("Error reading line. Make sure the file is UTF compliant and you have not reached the end of the file.");
    }
  }
}
