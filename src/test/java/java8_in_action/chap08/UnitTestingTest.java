package java8_in_action.chap08;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java8_in_action.chap03.functional_interface.MainUsingPredicate.filter;
import static org.junit.Assert.assertTrue;

public class UnitTestingTest {
  @Test
  public void testUnitTest() {
    Point p1 = new Point(5, 5);
    Point p2 = p1.moveRightBy(10);

    assertTrue(15 == p2.getX());
    assertTrue(5 == p2.getY());
  }

  @Test
  public void testLambdaTest() {
    Point p1 = new Point(10, 15);
    Point p2 = new Point(10, 20);

    int result = Point.compareByXAndThenY.compare(p1, p2);

    assertTrue(-1 == result);
  }

  @Test
  public void testMoveAllPointsRightBy() throws Exception {
    List<Point> points =
            Arrays.asList(new Point(5, 5), new Point(10, 5));
    List<Point> expectedPoints =
            Arrays.asList(new Point(15, 5), new Point(20, 5));
    List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
    assertTrue(expectedPoints == newPoints);
  }

  @Test
  public void testFilter() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
    List<Integer> even = filter(numbers, i -> i % 2 ==0);
    List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
    assertTrue(Arrays.asList(2, 4) == even);
    assertTrue(Arrays.asList(1, 2) == smallerThanThree);
  }
}
