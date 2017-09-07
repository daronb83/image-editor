package iedit;

/**
* Represents an RGB value
* @author Daron Barnes
*/
public class Pixel {

  private int red, green, blue;

  /**
  * Pixels represnt RGB values, each value being between 0-255
  * @param red the red value
  * @param green the green value
  * @param blue the blue value
  */
  public Pixel(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
  * Resets all values at once
  * @param red the red value
  * @param green the green value
  * @param blue the blue value
  */
  public void setRGB(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
  * Sets all values to the average value (grayscale)
  */
  public void average() {
    int average = (red + green + blue) / 3;
    red = average;
    green = average;
    blue = average;
  }

  /**
  * Inverts all values (255 - value)
  */
  public void invert() {
    red = 255 - red;
    green = 255 - green;
    blue = 255 - blue;
  }

  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }

  /**
  * Overrides the red value
  * @param red the new red value
  */
  public void setRed(int red) {
    if (red < 0) {
      red = 0;
    }
    else if (red > 255) {
      red = 255;
    }
    else {
      this.red = red;
    }
  }

  /**
  * Overrides the green value
  * @param green the new green value
  */
  public void setGreen(int green) {
    if (green < 0) {
      green = 0;
    }
    else if (green > 255) {
      green = 255;
    }
    else {
      this.green = green;
    }
  }

  /**
  * Overrides the blue value
  * @param blue the new blue value
  */
  public void setBlue(int blue) {
    if (blue < 0) {
      blue = 0;
    }
    else if (blue > 255) {
      blue = 255;
    }
    else {
      this.blue = blue;
    }
  }

}
