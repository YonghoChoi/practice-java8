package java8_in_action.chap03.method_ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MainUsingConstructorRef {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        for(Apple a : apples) {
            System.out.println(a.getWeight());
        }
    }

    private static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for(Integer e : list) {
            result.add(f.apply(e));
        }

        return result;
    }
}
