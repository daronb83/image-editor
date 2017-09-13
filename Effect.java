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
  public ImagePPM motionblur(ImagePPM image, int blurLength) {
    ImagePPM temp = new ImagePPM(image.getWidth(), image.getHeight());

    for (int h  = 0; h  < image.getHeight(); h++) {
      for (int w = 0; w < image.getWidth(); w++) {

        int averageRed = 0;
        int averageGreen = 0;
        int averageBlue = 0;
        int thisBlur = blurLength;

        if (thisBlur + w > image.getWidth()){
          thisBlur = image.getWidth() - w;
        }

        if (thisBlur <= 1){
          temp.pushRGB(image.getPixel(w,h).getRed(), image.getPixel(w,h).getGreen(), image.getPixel(w,h).getBlue());
        }
        else {
          for (int k = 0; k < thisBlur; k++){
            if (w == 0 && h == 0){
              System.out.print("(" + w + "," + h + ") ");
              System.out.println(image.getPixel(w+k,h).getRed() + "," + image.getPixel(w+k,h).getGreen() + "," + image.getPixel(w+k,h).getBlue());
            }
            averageRed += image.getPixel(w+k,h).getRed();
            averageGreen += image.getPixel(w+k,h).getGreen();
            averageBlue += image.getPixel(w+k,h).getBlue();
          }

          temp.pushRGB(averageRed/thisBlur, averageGreen/thisBlur, averageBlue/thisBlur);
        }
      }
    }
    return temp;
  }

}
