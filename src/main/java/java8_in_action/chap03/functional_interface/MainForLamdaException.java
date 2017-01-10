package java8_in_action.chap03.functional_interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainForLamdaException {
    public static void main(String[] args) throws IOException {
        processFile((BufferedReader br) -> br.readLine());
    }

    public static String processFile(ExceptionTest e) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data/data.txt"))) {
            return e.process(br);
        }
    }
}
