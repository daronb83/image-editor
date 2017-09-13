public class Effect {

  /**
  * Inverts each pixel value in the image (255 - value)
  * @param image the image to convert
  */
  public void invert(ImagePPM image) {
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        image.getPixel(i,j).invert();
      }
    }
  }

  /**
  * Averages the values of each pixel (R + G + B) / 3
  * @param image the image to convert
  */
  public void grayscale(ImagePPM image) {
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        image.getPixel(i,j).average();
      }
    }
  }

  /**
  * Embosses the image
  * @param image the image to convert
  */
  public void emboss(ImagePPM image) {

    for (int i = image.getWidth() - 1; i >= 0; i--) {
      for (int j = image.getHeight() - 1; j >= 0; j--) {
        int redDiff, greenDiff, blueDiff;
        int v = 128;

        if (i > 0 && j > 0){
          redDiff = image.getPixel(i,j).getRed() - image.getPixel(i-1,j-1).getRed();
          greenDiff = image.getPixel(i,j).getGreen() - image.getPixel(i-1,j-1).getGreen();
          blueDiff = image.getPixel(i,j).getBlue() - image.getPixel(i-1,j-1).getBlue();

          if (Math.abs(redDiff) < Math.abs(greenDiff)){
            redDiff = greenDiff;
          }
          if (Math.abs(redDiff) < Math.abs(blueDiff)){
            redDiff = blueDiff;
          }

          v += redDiff;
        }

        image.getPixel(i,j).setRed(v);
        image.getPixel(i,j).setGreen(v);
        image.getPixel(i,j).setBlue(v);
      }
    }
  }

  /**
  * Adds a blur effect to the image
  * @param image the image to convert
  * @param blurLength the number of pixels that affect each pixel
  */
  public void motionblur(ImagePPM image, int blurLength) {
    for (int i = image.getWidth() - 1; i >= 0; i--) {
      for (int j = image.getHeight() - 1; j >= 0; j--) {
        int averageRed = 0;
        int averageGreen = 0;
        int averageBlue = 0;
        int thisBlur = blurLength;

        if (thisBlur + i > image.getWidth()){
          thisBlur = image.getWidth() - i;
        }

        for (int k = 0; k < thisBlur; k++){
          averageRed += image.getPixel(i+k,j).getRed();
          averageGreen += image.getPixel(i+k,j).getGreen();
          averageBlue += image.getPixel(i+k,j).getBlue();
        }

        image.getPixel(i,j).setRed(averageRed/thisBlur);
        image.getPixel(i,j).setGreen(averageGreen/thisBlur);
        image.getPixel(i,j).setBlue(averageBlue/thisBlur);
      }
    }
  }

}
