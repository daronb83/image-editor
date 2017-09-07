package iedit;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
* Handles reading and writing of ppm images
* @author Daron Barnes
*/
public class IO {

  /**
  * Reads a PPM Image file and stores it as an ImagePPM object
  * @param inputFile the path/name of the PPM Image
  * @return The ppm image stored as an ImagePPM object
  */
  public ImagePPM scanImage(String inputFile) {

    File file = new File(inputFile);

    boolean needHeader = true;
    boolean needMax = true;
    boolean needImage = true;
    int height = 0;
    int width = 0;
    int red = -1;
    int green = -1;
    int blue = -1;
    ImagePPM image = new ImagePPM(0,0);

    try {
      Scanner scanner = new Scanner(file);

      while (scanner.hasNext()) {
        String next = scanner.next();

        // skip comments
        while (next.indexOf('#') >= 0) {
          scanner.nextLine();
          if (scanner.hasNext()) {
            next = scanner.next();
          }
          else {
            next = "";
          }
        }

        // collect header information
        if (needImage) {
          if (needHeader) {
            needHeader = false;
          }
          else if (width == 0) {
            width = Integer.parseInt(next);
          }
          else if (height == 0) {
            height = Integer.parseInt(next);
            image = new ImagePPM(height, width);
          }
          else if (needMax) {
            needMax = false;
            needImage = false;
          }
        }

        // load pixels
        else {
          if (red < 0) {
            red = Integer.parseInt(next);
          }
          else if (green < 0) {
            green = Integer.parseInt(next);
          }
          else if (blue < 0) {
            blue = Integer.parseInt(next);
            image.pushRGB(red, green, blue);
            red = green = blue = -1;
          }
        }
      }
      scanner.close();
    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }

    return image;
  }

  /**
  * Writes an ImagePPM object to File
  * @param image the ImagePPM object to writeImage
  * @param outputFile the path/filename to write to
  */
  public void writeImage(ImagePPM image, String outputFile) {
    System.out.println(image.toString());
  }

}
