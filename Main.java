package ieditor;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    String inputFile = null;
    String outputFile = null;
    String filter = null;
    int blurLength = 0;
    PPM image;

    try {
      inputFile = args[0];
      outputFile = args[1];
      filter = args[2];

      if (!(filter.equals("invert") || filter.equals("grayscale") || filter.equals("emboss") || filter.equals("motionblur"))) {
        uException();
      }

      if (filter.equals("motionblur")) {
        blurLength = Integer.parseInt(args[3]);
      }
    }
    catch (IndexOutOfBoundsException | NumberFormatException e) {
      uException();
    }

    IO io = new IO();
    Filter effect = new Filter();

    try {
      image = io.scanImage(inputFile);
      image = effect.addFilter(image, filter, blurLength);
      io.writeImage(image, outputFile);
    }
    catch (IOException | NumberFormatException e){
      System.out.println("Error: " + e.getMessage());
      uException();
    }

    System.out.println("Wrote: " + outputFile);
  }

  private static void uException() {
    System.out.println("USAGE: java ieditor.Main in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)");
    System.exit(0);
  }
}
