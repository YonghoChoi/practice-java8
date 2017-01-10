package java8_in_action.chap03.method_ref;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        System.out.println("== not method reference ==");
        print(str);

        List<String> str2 = Arrays.asList("a", "b", "A", "B");
        str2.sort(String::compareToIgnoreCase);

        System.out.println("\n== method reference ==");
        print(str2);

    }

    public static void print(List<String> str) {
        for(String s : str) {
            System.out.println(s);
        }
    }
}
