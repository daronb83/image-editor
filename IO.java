import java.util.Scanner;
import java.io.*; 

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
    ImagePPM image = null;

    try {
      Scanner scanner = new Scanner(file);

      while (scanner.hasNext()) {
        String next = scanner.next();

        // skips to the next line if the current word contains '#'
        while (next.indexOf('#') >= 0) {
          scanner.nextLine();
          if (scanner.hasNext()) {
            next = scanner.next();
          }
          else {
            next = "";
          }
        }

        // save word as header information, if still needed
        if (needImage) {
          if (needHeader) {
            needHeader = false;
          }
          else if (width == 0) {
            width = Integer.parseInt(next);
          }
          else if (height == 0) {
            height = Integer.parseInt(next);
            image = new ImagePPM(width, height);
          }
          else if (needMax) {
            needMax = false;
            needImage = false;
          }
        }

        // save word as pixel component if header is complete
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
    BufferedWriter writer = null;

    try {
      writer = new BufferedWriter(new FileWriter(outputFile));
      writer.write(image.toString());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        writer.close( );
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
