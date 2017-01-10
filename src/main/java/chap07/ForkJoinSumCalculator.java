package chap07;

public class ForkJoinSumCalculator
        extends java.util.concurrent.RecursiveTask<Long> {  // RecursiveTask를 상속받아 포크/조인 프레임워크에서 사용할 태스크를 생성.
  private final long[] numbers;
  private final int start;  // 서브 태스크에서 처리할 배열의 초기 위치
  private final int end;    // 서브 태스크에서 처리할 배열의 최종 위치
  public static final long THRESHOLD = 10_000;  // 이 값 이하의 서브태스크는 더이상 분할할 수 없다.

  // 메인 태스크를 생성할 때 사용할 공개 생성자
  public ForkJoinSumCalculator(long[] numbers) {
    this(numbers, 0, numbers.length);
  }

  // 메인 태스크의 서브태스크를 재귀적으로 만들 때 사용할 비공개 생성자
  public ForkJoinSumCalculator(long[] numbers, int start, int end) {
    this.numbers = numbers;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {  // RecursiveTask의 추상 메서드 오버라이드
    int length = end - start; // 이 태스크에서 더할 배열의 길이
    if(length <= THRESHOLD) {
      return computeSequentially(); // 기준 값과 같거나 작으면 순차적으로 결과를 계산.
    }

    // 배열의 첫 번째 절반을 더하도록 서브 태스크를 생성
    ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
    leftTask.fork();  // ForkJoinPool의 다른 스레드로 새로 생성한 태스크를 비동기로 실행.

    // 배열의 나머지 절반을 더하도록 서브태스크를 생성
    ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
    Long rightResult = rightTask.compute(); // 두 번째 서브태스크를 동기 실행한다.(이 때 추가로 분할이 일어날 수 있다.)
    Long leftResult = leftTask.join();  // 첫 번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다린다.
    return rightResult + leftResult;  // 두 서브태스크의 결과를 조합한 값이 이 태스크의 결과
  }

  // 더 분할할 수 없을 때 서브태스크의 결과를 계산하는 단순한 알고리즘
  private long computeSequentially() {
    long sum = 0;
    for (int i = start; i < end; i++) {
      sum += numbers[i];
    }
    return sum;
  }
}
