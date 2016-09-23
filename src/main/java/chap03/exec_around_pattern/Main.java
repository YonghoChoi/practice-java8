package chap03.exec_around_pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(processFile());

            // 함수형 인터페이스 이용
//            System.out.println(processFileByFunctionalInterface((BufferedReader br) -> br.readLine())); // 람다 전달
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data/data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFileByFunctionalInterface(BufferedReaderProcessor p) throws IOException {   // 동작 파라미터화
        try(BufferedReader br = new BufferedReader(new FileReader("data/data.txt"))) {
            return p.process(br);   // 동작 실행
        }
    }
}
