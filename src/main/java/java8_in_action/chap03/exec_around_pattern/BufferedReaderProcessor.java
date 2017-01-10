package java8_in_action.chap03.exec_around_pattern;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b ) throws IOException;
}
