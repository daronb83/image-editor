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
    X = Y = 0;
    img = new Pixel[height][width];
  }

  /**
  * Pushes a single RGB pixel into an empty or partially-filled image
  * @param red the red value
  * @param blue the blue value
  * @param green the green value
  * @return true if the pixel was pushed successfully, false if the image is
  * full or if one of the values is not between 0 and 255
  */
  public void pushRGB(int red, int green, int blue) {
    Pixel pixel = new Pixel(red, green, blue);
    img[X][Y] = pixel;
    X++;
    Y++;
    if (X == width) {
      X = 0;
    }
    if (Y == height) {
      Y = 0;
    }
  }

  /**
  * Returns the Pixel found at (x,y)
  * @param x the pixel's x coordinate
  * @param y the pixel's y coordinate
  * @return Pixel the pixel found at (x,y)
  */
  public Pixel getPixel(int x, int y) {
    return img[x][y];
  }

  /**
  * Replaces a pixel at (x,y)
  * @param x the pixel's x coordinate
  * @param y the pixel's y coordinate
  * @param pixel the pixel to insert into the image at (x,y)
  * @return boolean true if the replacement is successful, false if x or y
  * are not valid coordinates
  */
  public void setPixel(int x, int y, Pixel pixel) {
    if (x > 0 && x < width && y > 0 && y < height) {
      img[x][y] = pixel;
    }
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
