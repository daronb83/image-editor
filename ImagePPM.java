package iedit;

/**
* Stores a PPM image
* @author Daron Barnes
*/
public class ImagePPM {

  private int height, width, X, Y;
  private Pixel[][] img;

  /**
  * @param height the height of the image in pixels
  * @param width the width of the image in pixels
  */
  public ImagePPM (int height, int width) {
    this.height = height;
    this.width = width;
    x = y = 0;
    Pixel[][] = new Pixel[height][width];
  }

  /**
  * Pushes a single RGB pixel into an empty or partially-filled image
  * @param red the red value
  * @param blue the blue value
  * @param green the green value
  * @return true if the pixel was pushed successfully, false if the image is
  * full or if one of the values is not between 0 and 255
  */
  public boolean pushRGB(int red, int blue, int green) {
    return false;
  }

  /**
  * Returns the Pixel found at (x,y)
  * @param x the pixel's x coordinate
  * @param y the pixel's y coordinate
  * @return Pixel the pixel found at (x,y)
  */
  public Pixel getPixel(int x, int y) {

  }

  /**
  * Replaces a pixel at (x,y)
  * @param x the pixel's x coordinate
  * @param y the pixel's y coordinate
  * @param pixel the pixel to insert into the image at (x,y)
  * @return boolean true if the replacement is successful, false if x or y
  * are not valid coordinates
  */
  public boolean setPixel(int x, int y, Pixel pixel) {

  }

  /**
  * @return a string correctly formatted as a PPM image file, ready for writing
  * to file
  */
  @Override
  public String toString() {
    return "";
  }
}
