package chap06;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PrimeTest {
    public boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)	// 2부터 candidate 미만 사이의 자연수 생성.
                .noneMatch(i -> candidate % i == 0);
    }

    public boolean isPrime2(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        System.out.println(candidateRoot);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime2(candidate)));
    }

    @Test
    public void testPrime() {
        System.out.println(partitionPrimes(10));
    }
}
