package ieditor;

import java.util.Scanner;
import java.io.*;

/**
* Handles reading and writing of ppm images
* @author Daron Barnes
*/
public class IO {

  /**
  * Reads a PPM Image file and stores it as a PPM object
  * @param inputFile the path/name of the PPM Image
  * @return The ppm image stored as a PPM object
  */
  public PPM scanImage(String inputFile) throws IOException, NumberFormatException {
    File file = new File(inputFile);
    Scanner scanner = new Scanner(file);
    PPM image = null;
    boolean needHeader = true;

    while (scanner.hasNext()) {

      if (needHeader) {
        skipComments(scanner); // skip PPM header
        int width = Integer.parseInt(skipComments(scanner));
        int height = Integer.parseInt(skipComments(scanner));
        image = new PPM(width, height);
        skipComments(scanner); // skip max value (always 225)
        needHeader = false;
      }
      else {
        int red = Integer.parseInt(skipComments(scanner));
        int green = Integer.parseInt(skipComments(scanner));
        int blue = Integer.parseInt(skipComments(scanner));
        image.pushRGB(red, green, blue);
      }
    }

    scanner.close();
    return image;
  }

  /**
   * Helper for scanImage, skips comments in the image file
   */
  private String skipComments(Scanner scanner) throws IOException {
    String next = scanner.next();

    while (next.indexOf('#') >= 0) {
      scanner.nextLine();
      next = scanner.next();
    }

    return next;
  }

  /**
  * Writes an PPM object to File
  *
  * @param image the PPM object to writeImage
  * @param outputFile the path/filename to write to
  */
  public void writeImage(PPM image, String outputFile) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
    writer.write(image.toString());
    writer.close();
  }

}
