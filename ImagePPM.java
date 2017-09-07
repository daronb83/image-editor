package iedit;
import java.lang.StringBuilder;

/**
* Stores a PPM image
* @author Daron Barnes
*/
public class ImagePPM {

  private int height, width, x, y;
  private Pixel[][] img;

  /**
  * @param height the height of the image in pixels
  * @param width the width of the image in pixels
  */
  public ImagePPM (int width, int height) {
    this.width = width;
    this.height = height;
    x = y = 0;
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
    img[y][x] = pixel;
    x++;
    if (x == width) {
      x = 0;
      y++;
    }
  }

  /**
  * Returns the Pixel found at (x,y)
  * @param x the pixel's x coordinate
  * @param y the pixel's y coordinate
  * @return Pixel the pixel found at (x,y)
  */
  public Pixel getPixel(int x, int y) {
    return img[y][x];
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
      img[y][x] = pixel;
    }
  }

  /**
  * @return a string correctly formatted as a PPM image file, ready for writing
  * to file
  */
  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("P3\n");
    output.append(width);
    output.append(" ");
    output.append(height);
    output.append("\n255\n");
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        output.append(img[i][j].getRed());
        output.append(" ");
        output.append(img[i][j].getGreen());
        output.append(" ");
        output.append(img[i][j].getBlue());
        output.append("\n");
      }
    }
    return output.toString();
  }
}
