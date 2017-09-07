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

    try {
      Scanner scanner = new Scanner(file);

      while (scanner.hasNext()){
        System.out.println(scanner.next());
      }

      scanner.close();
    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }

    return new ImagePPM (0,0);
  }

  /**
  * Writes an ImagePPM object to File
  * @param image the ImagePPM object to writeImage
  * @param outputFile the path/filename to write to
  */
  public void writeImage(ImagePPM image, String outputFile) {

  }

}
