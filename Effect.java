package ieditor;

public class Effect {

  /**
  * Inverts each pixel value in the image (255 - value)
  * @param image the image to convert
  */
  public ImagePPM invert(ImagePPM image) {
    return image;
  }

  /**
  * Averages the values of each pixel (R + G + B) / 3
  * @param image the image to convert
  */
  public ImagePPM grayscale(ImagePPM image) {
    return image;
  }

  /**
  * Embosses the image
  * @param image the image to convert
  */
  public ImagePPM emboss(ImagePPM image) {
    return image;
  }

  /**
  * Adds a blur effect to the image
  * @param image the image to convert
  * @param blurLength the number of pixels that affect each pixel
  */
  public ImagePPm motionblur(ImagePPM image, int blurLength) {
    return image;
  }

}
