package ieditor;

public class Filter {

  /**
  * Applies a filter to the input image
  * @param image the image to convert
  * @param filter the type of filter to apply (invert | grayscale | emboss | motionblur)
  * @param blurLength if motionblur is selected, the length of blur to apply
  */
  public PPM addFilter(PPM image, String filter, int blurLength) {

    switch (filter) {
      case "invert" :
        invert(image);
        break;
      case "grayscale" :
        grayscale(image);
        break;
      case "emboss" :
        emboss(image);
        break;
      case "motionblur" :
        image = motionblur(image, blurLength);
        break;
    }

    return image;
  }

  /**
  * Inverts each pixel value in the image (255 - value)
  * @param image the image to convert
  */
  public void invert(PPM image) {
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
  public void grayscale(PPM image) {
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
  public void emboss(PPM image) {

    for (int i = image.getWidth() - 1; i >= 0; i--) {
      for (int j = image.getHeight() - 1; j >= 0; j--) {
        int redDiff, greenDiff, blueDiff;
        redDiff = greenDiff = blueDiff = 0;
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
  * Adds a blur filter to the image
  * @param image the image to convert
  * @param blurLength the number of pixels that affect each pixel
  */
  public PPM motionblur(PPM image, int blurLength) {
    PPM temp = new PPM(image.getWidth(), image.getHeight());

    for (int h  = 0; h  < image.getHeight(); h++) {
      for (int w = 0; w < image.getWidth(); w++) {
        int averageRed, averageGreen, averageBlue;
        averageRed = averageGreen = averageBlue = 0;
        int thisBlur = blurLength;

        if (thisBlur + w > image.getWidth()){
          thisBlur = image.getWidth() - w;
        }

        if (thisBlur <= 1){
          temp.pushRGB(image.getPixel(w,h).getRed(), image.getPixel(w,h).getGreen(), image.getPixel(w,h).getBlue());
        }
        else {
          for (int k = 0; k < thisBlur; k++){
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
