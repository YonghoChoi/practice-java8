package java8_in_action.chap03.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainUsingPredicate {
    public static void main(String[] args) {
        List<String> listOfString = Arrays.asList("string 1", "", "string 3", "string 4", "");

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfString, nonEmptyStringPredicate);
        for(String s : nonEmpty) {
            System.out.println(s);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s : list) {
            if(p.test(s)) {
                results.add(s);
            }
        }

        return results;
    }
}
