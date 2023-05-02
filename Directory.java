package workingDirectory;

import java.io.File;
import java.io.IOException;

public class Directory {
  public static void main(String[] args) {
    // Get the current working directory
    String workingDir = System.getProperty("user.dir");

    // Create the file object for hello.txt in the current working directory
    File file = new File(workingDir + "/hello.txt");

    try {
      // Create the file if it doesn't exist
      if (file.createNewFile()) {
        System.out.println("File created: " + file.getAbsolutePath());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred while creating the file.");
      e.printStackTrace();
    }
  }
}