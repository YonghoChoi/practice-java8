package chap03.method_ref;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class MainForPractical {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple("green", 100),
                new Apple("red", 10),
                new Apple("blue", 140),
                new Apple("yellow", 120)
        );

        step1(inventory);
//        step2(inventory);
//        step3(inventory);
//        step4(inventory);

        print(inventory);
    }

    private static void step1(List<Apple> inventory) {
        inventory.sort(new AppleComparator());
    }

    private static void step2(List<Apple> inventory) {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
    }

    private static void step3(List<Apple> inventory) {
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }

    private static void step4(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight));
    }

    private static void print(List<Apple> inventory) {
        for(Apple a : inventory) {
            System.out.println(a.getName() + ", " + a.getWeight());
        }
    }
}
