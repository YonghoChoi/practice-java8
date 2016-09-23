package chap03.functional_interface;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface ExceptionTest {
    String process(BufferedReader b ) throws IOException;
}
