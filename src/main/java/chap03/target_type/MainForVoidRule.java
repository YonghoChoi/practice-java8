package chap03.target_type;

import java.util.function.Consumer;

public class MainForVoidRule {
    public static void main(String[] args) {
        Consumer<String> b = s -> s.length();
        process(s -> s.length());
    }

    public static void process(Consumer<String> c) {

    }
}
