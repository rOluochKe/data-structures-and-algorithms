package Java;

import java.io.File;

public class FileSystemSearch {

  public static void find(String path, String filename) {
    File directory = new File(path);
    File[] files = directory.listFiles();

    if (files != null) {
      for (File file : files) {
        if (file.isDirectory()) {
          find(file.getAbsolutePath(), filename);
        } else {
          if (file.getName().equals(filename)) {
            System.out.println(file.getAbsolutePath());
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    find("rootPath", "example.txt"); // Provide root path and filename to search for
  }
}