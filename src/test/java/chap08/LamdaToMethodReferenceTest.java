package chap08;

import lombok.Getter;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class LamdaToMethodReferenceTest {
  @Test
  public void testLamda() {
    List<Dish> menu = Arrays.asList(
            new Dish(),
            new Dish()
    );
    Map<CaloricLevel, List<Dish>> dishiesByCaloricLevel =
            menu.stream().collect(
                    groupingBy(dish -> {
                      if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                      else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                      else return CaloricLevel.FAT;
                    })
            );
  }

  @Test
  public void testMethodReference() {
    List<Dish> menu = Arrays.asList(
            new Dish(),
            new Dish()
    );
    Map<CaloricLevel, List<Dish>> dishiesByCaloricLevel =
            menu.stream().collect(groupingBy(Dish::getCaloricLevel));
  }
}

enum CaloricLevel { DIET, NORMAL, FAT }

@Getter
class Dish {
  private int calories;

  public CaloricLevel getCaloricLevel() {
    if(this.getCalories() <= 400) return CaloricLevel.DIET;
    else if (this.getCalories() <= 700) return CaloricLevel.NORMAL;
    else return CaloricLevel.FAT;
  }
  public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
  }
}

