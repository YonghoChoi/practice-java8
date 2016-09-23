package chap03.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MainUsingFunction {
    public static void main(String[] args) {
        List<Integer> lst = map(Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length());

        for(Integer i : lst) {
            System.out.println(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();

        for(T s : list) {
            result.add(f.apply(s));
        }

        return result;
    }
}
