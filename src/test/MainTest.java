
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

class MainTest {
    Rectangle rect;
    Rectangle rect2;
    Triangle triangle;
    Circle circle;
    Circle circle2;

    @BeforeEach
    void setUp(){
        rect = new Rectangle(new Point(10,10), new Point(50,50));
        rect2 = new Rectangle(new Point(15,30), new Point(20,40));
        triangle = new Triangle(new Point(20,20), new Point(10,40),new Point(30,60));
        circle = new Circle(new Point(50,50),10);
        circle2 = new Circle(new Point(20,40),5);
    }

    @Test
    @DisplayName("Should return the center of a Shape.")
     void testGetCenter(){
        assertEquals(30,rect.getCenter().getX());
        assertEquals(30,rect.getCenter().getY());
        assertEquals(20,triangle.getCenter().getX());
        assertEquals(40,triangle.getCenter().getY());
        assertEquals(50,circle.getCenter().getX());
        assertEquals(50,circle.getCenter().getY());
    }

    @Test
    @DisplayName("Should return the surface area of a Shape.")
    void testGetArea(){
        assertEquals(1600,rect.getArea());
        assertEquals(300,triangle.getArea());
        assertEquals(314.1592653589793,circle.getArea());
    }

    @Test
    @DisplayName("Should return the circumference of a Shape.")
    void testGetCircumference(){
        assertEquals(160,rect.getCircumference());
        assertEquals(91.87600727863641,triangle.getCircumference());
        assertEquals(62.83185307179586,circle.getCircumference());
    }

    @Test
    @DisplayName("Should give true if a point is within a Shape and false if not.")
    void testInShape(){
        assertTrue(rect.inShape(new Point(20,20)));
        assertFalse(rect.inShape(new Point(60,60)));
        assertTrue(triangle.inShape(new Point(15,30)));
        assertFalse(triangle.inShape(new Point(20,10)));
        assertTrue(circle.inShape(new Point(50,55)));
        assertFalse(circle.inShape(new Point(50,65)));
    }

    @Test
    @DisplayName("Should return the euclidean distance to another Shape.")
    void testGetEuclideanDistance(){
        assertEquals(14.142135623730951,rect.getEuclideanDistance(triangle));
        assertEquals(28.284271247461902,rect.getEuclideanDistance(circle));
        assertEquals(31.622776601683793,circle.getEuclideanDistance(triangle));
    }

    @Test
    @DisplayName("Should tell if a Shape is in another Shape.")
    void testInAnotherShape(){
        assertFalse(rect.inAnotherShape(triangle));
        assertTrue(rect2.inAnotherShape(triangle));
        assertTrue(circle2.inAnotherShape(triangle));
        assertTrue(circle2.inAnotherShape(rect));
        assertFalse(circle.inAnotherShape(rect));
    }

    @Test
    @DisplayName("Should move Shape.")
    void testMoveShape(){
        rect.moveShape(10,20);
        triangle.moveShape(30,-10);
        circle.moveShape(5,-20);
        assertEquals(40,rect.getCenter().getX());
        assertEquals(50,rect.getCenter().getY());
        assertEquals(50,triangle.getCenter().getX());
        assertEquals(30,triangle.getCenter().getY());
        assertEquals(55,circle.getCenter().getX());
        assertEquals(30,circle.getCenter().getY());
    }
}
