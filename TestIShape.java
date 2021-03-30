import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * This class tests the IShape Interface.
 */
public class TestIShape {

  IShape r1;
  IShape s1;
  IShape o1;
  IShape o2;
  final double DELTA = 0.001;
  @Before
  public void setUp() {

    r1 = new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), 10, 60.2);
    s1 = new Rectangle("square", 0, 10, 6, 6, new Color(69, 42, 0), 5, 70.4);
    o1 = new Oval("circle", 7, -10, 4.1, 4.1, new Color(100, 100, 100), 10, 60);
    o2 = new Oval("oval", -5, -5, 3.3, 7.3, new Color(200, 30, 200), 10, 60);

  }

  @Test
  public void testGetArea() {

    assertEquals(24.200, r1.getArea(), DELTA);
    assertEquals(36.0, s1.getArea(), DELTA);
    assertEquals(52.810, o1.getArea(), DELTA);
    assertEquals(75.681, o2.getArea(), DELTA);

  }

  @Test
  public void testGetPerimeter() {

    assertEquals(19.8, r1.getPerimeter(), DELTA);
    assertEquals(24.0, s1.getPerimeter(), DELTA);
    assertEquals(25.761, o1.getPerimeter(), DELTA);
    assertEquals(20.734, o2.getPerimeter(), DELTA);
  }

  @Test
  public void testGetX() {
    assertEquals(0, r1.getX(), DELTA);
    assertEquals(0, s1.getX(), DELTA);
    assertEquals(7, o1.getX(), DELTA);
    assertEquals(-5, o2.getX(), DELTA);
  }

  @Test
  public void testGetY() {
    assertEquals(0, r1.getY(), DELTA);
    assertEquals(10, s1.getY(), DELTA);
    assertEquals(-10, o1.getY(), DELTA);
    assertEquals(-5, o2.getY(), DELTA);
  }

  @Test
  public void testGetLength() {
    assertEquals(5.5, r1.getLength(), DELTA);
    assertEquals(6, s1.getLength(), DELTA);
    assertEquals(4.1, o1.getLength(), DELTA);
    assertEquals(3.3, o2.getLength(), DELTA);
  }

  @Test
  public void testGetWidth() {
    assertEquals(4.4, r1.getWidth(), DELTA);
    assertEquals(6, s1.getWidth(), DELTA);
    assertEquals(4.1, o1.getWidth(), DELTA);
    assertEquals(7.3, o2.getWidth(), DELTA);
  }

  @Test
  public void testGetColor() {

    assertEquals(150.0, r1.getColor().getRed(), DELTA);
    assertEquals(200.0, r1.getColor().getGreen(), DELTA);
    assertEquals(60.0, r1.getColor().getBlue(), DELTA);

    assertEquals(69.0, s1.getColor().getRed(), DELTA);
    assertEquals(42.0, s1.getColor().getGreen(), DELTA);
    assertEquals(0.0, s1.getColor().getBlue(), DELTA);

    assertEquals(100, o1.getColor().getRed(), DELTA);
    assertEquals(100, o1.getColor().getGreen(), DELTA);
    assertEquals(100, o1.getColor().getBlue(), DELTA);

    assertEquals(200, o2.getColor().getRed(), DELTA);
    assertEquals(30, o2.getColor().getGreen(), DELTA);
    assertEquals(200, o2.getColor().getBlue(), DELTA);
  }

  @Test
  public void testGetTimeAppear() {
    assertEquals(10, r1.getTimeAppear(), DELTA);
    assertEquals(5, s1.getTimeAppear(), DELTA);
    assertEquals(10, o1.getTimeAppear(), DELTA);
    assertEquals(10, o2.getTimeAppear(), DELTA);
  }

  @Test
  public void testGetTimeDisappear() {
    assertEquals(10, r1.getTimeAppear(), DELTA);
    assertEquals(5, s1.getTimeAppear(), DELTA);
    assertEquals(10, o1.getTimeAppear(), DELTA);
    assertEquals(10, o2.getTimeAppear(), DELTA);
  }

  @Test
  public void testGetName() {
    assertEquals("rectangle", r1.getName());
    assertEquals("square", s1.getName());
    assertEquals("circle", o1.getName());
    assertEquals("oval", o2.getName());
  }

  @Test
  public void testSetNewXY() {

    r1.setNewXY(5, 5);
    assertEquals(5, r1.getX(), DELTA);
    assertEquals(5, r1.getY(), DELTA);

    s1.setNewXY(-10, 45);
    assertEquals(-10, s1.getX(), DELTA);
    assertEquals(45, s1.getY(), DELTA);

    o1.setNewXY(-7, -23);
    assertEquals(-7, o1.getX(), DELTA);
    assertEquals(-23, o1.getY(), DELTA);

    o2.setNewXY(9, 12);
    assertEquals(9, o2.getX(), DELTA);
    assertEquals(12, o2.getY(), DELTA);

  }

  @Test
  public void testSetNewColor() {
    Color newColor = new Color(50, 100, 50);

    r1.setNewColor(newColor);
    s1.setNewColor(newColor);
    o1.setNewColor(newColor);
    o2.setNewColor(newColor);

    assertEquals(50.0, r1.getColor().getRed(), DELTA);
    assertEquals(100.0, r1.getColor().getGreen(), DELTA);
    assertEquals(50.0, r1.getColor().getBlue(), DELTA);

    assertEquals(50.0, s1.getColor().getRed(), DELTA);
    assertEquals(100.0, s1.getColor().getGreen(), DELTA);
    assertEquals(50.0, s1.getColor().getBlue(), DELTA);

    assertEquals(50.0, o1.getColor().getRed(), DELTA);
    assertEquals(100.0, o1.getColor().getGreen(), DELTA);
    assertEquals(50.0, o1.getColor().getBlue(), DELTA);

    assertEquals(50.0, o2.getColor().getRed(), DELTA);
    assertEquals(100.0, o2.getColor().getGreen(), DELTA);
    assertEquals(50.0, o2.getColor().getBlue(), DELTA);

  }

  @Test
  public void testSetScale() {

    double doubleScale = 2.0;
    double halfScale = 0.5;

    r1.setScale(doubleScale);
    s1.setScale(halfScale);
    o1.setScale(doubleScale);
    o2.setScale(halfScale);

    assertEquals(11.0, r1.getLength(), DELTA);
    assertEquals(3.0, s1.getLength(), DELTA);
    assertEquals(8.2, o1.getLength(), DELTA);
    assertEquals(1.65, o2.getLength(), DELTA);

    assertEquals(8.8, r1.getWidth(), DELTA);
    assertEquals(3.0, s1.getWidth(), DELTA);
    assertEquals(8.2, o1.getWidth(), DELTA);
    assertEquals(3.65, o2.getWidth(), DELTA);
  }

  @Test
  public void testCloneShape() {

    IShape r1Clone = r1.cloneShape();
    IShape s1Clone = s1.cloneShape();
    IShape o1Clone = o1.cloneShape();
    IShape o2Clone = o2.cloneShape();

    assertNotEquals(r1, r1Clone);
    assertNotEquals(s1, s1Clone);
    assertNotEquals(o1, o1Clone);
    assertNotEquals(o2, o2Clone);
  }

 @Test
  public void testToString() {
    assertEquals(
        "\n"
            + "Name: rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,0.0), Width: 4.4, Height: 5.5, Color: (150.0,200.0,60.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=60.2\n",
        r1.toString());

    assertEquals(
        "\n"
            + "Name: square\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,10.0), Width: 6.0, Height: 6.0, Color: (69.0,42.0,0.0)\n"
            + "Appears at t=5.0\n"
            + "Disappears at t=70.4\n",
        s1.toString());
    assertEquals(
        "\n"
            + "Name: circle\n"
            + "Type: oval\n"
            + "Min corner: (7.0,-10.0), Width: 4.1, Height: 4.1, Color: (100.0,100.0,100.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=60.0\n",
        o1.toString());
    assertEquals(
        "\n"
            + "Name: oval\n"
            + "Type: oval\n"
            + "Min corner: (-5.0,-5.0), Width: 7.3, Height: 3.3, Color: (200.0,30.0,200.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=60.0\n",
        o2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNullColor(){
    IShape invalidShape = new Rectangle("rectangle", 0, 0, 5.5, 4.4, null, 10, 60.2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegRadius(){
    IShape invalidShape = new Oval("circle", 7, -10, -4.1, 4.1, new Color(100, 100, 100), 10, 60);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegLength(){
    IShape invalidShape = new Rectangle("rectangle", 0, 0, -5.5, 4.4, new Color(150, 200, 60), 10, 60.2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegAppear(){
    IShape invalidShape = new Rectangle("rectangle", 0, 0, 5.5, -4.4, new Color(150, 200, 60), 10, 60.2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegDisappear(){
    IShape invalidShape = new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), -10, 60.2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegWidth(){
    IShape invalidShape = new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), 10, -60.2);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidConstructor(){

    //when timeDisappear is less than time appear
    IShape invalidShape = new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), 10, 9.9);
  }



}
