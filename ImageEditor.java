package iedit;

public class ImageEditor {

  public static void main(String[] args) {
    // 1. Validate Args
    validateArgs(args);
    System.out.println("Pass args");

    // 2. Read image
    // 3. Execute transition
    // 4. Write image
  }


  private static void validateArgs(String[] args) {
    int filterPos = 2;

    if (args.length > 2) {
      if (args[filterPos].equals("invert") || args[filterPos].equals("grayscale") ||
        args[filterPos].equals("emboss")) {
        if (args.length == 3){
          return;
        }
      }
      else if (args[filterPos].equals("motionblur")) {
        if (args.length == 4){
          return;
        }
      }
    }

    System.out.println("USAGE: java ImageEditor in-file out-file
      (grayscale|invert|emboss|motionblur motion-blur-length)");

    System.exit(0);
  }

}
