public class ImageEditor {

  public static void main(String[] args) {
    // args[] positions
    int inputFile = 0;
    int outputFile = 1;
    int effectType = 2;
    int blurLength = 3;

    // 1. Validate Args
    validateArgs(args);

    // 2. Read image
    IO io = new IO();
    ImagePPM image = io.scanImage(args[inputFile]);

    // 3. Execute transition
    Effect effect = new Effect();
    switch (args[effectType]) {
      case "invert" :
        effect.invert(image);
        break;

      case "grayscale" :
        effect.grayscale(image);
        break;

      case "emboss" :
        effect.emboss(image);
        break;

      case "motionblur" :
        effect.motionblur(image, Integer.parseInt(args[blurLength]));
        break;
    }

    // 4. Write image
    io.writeImage(image, args[outputFile]);
    System.out.println("Wrote " + args[effectType] + " image to " + args[outputFile]);
  }

  /**
  * validates args[] for correct input
  * @param args the Commandline arguments array from main(String[] args)
  */
  private static void validateArgs(String[] args) {
    int effectType = 2;

    if (args.length > 2) {
      if (args[effectType].equals("invert") || args[effectType].equals("grayscale") ||
        args[effectType].equals("emboss")) {
        if (args.length == 3){
          return;
        }
      }
      else if (args[effectType].equals("motionblur")) {
        if (args.length == 4){
          return;
        }
      }
    }

    System.out.println("USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)");

    System.exit(0);
  }

}
