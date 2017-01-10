package java8_syntax.intersection;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public class IntersectionType {
  public static void main(String[] args) {
    // Tip : 람다도 .class 파일이 생성되는 클래스이다.
    normal((Function)s->s);
    intersection((Function & Serializable & Cloneable) s->s);
    genericIntersection((Function & Serializable & Cloneable) s->s);
    usingDefaultMethod((Function & Serializable & Cloneable & Hello & Hi) s->s);
    usingDefaultMethodByCallback((Function & Serializable & Cloneable & Hello & Hi)s->s, o -> {
      o.hello();
      o.hi();
    });
  }

  private static void normal(Function o) {

  }

  // 인터페이스를 하나 이상 정의하여 람다식 사용 가능.
  // 이 인터페이스들은 선언된 모든 인터페이스의 메소드 총 합이 1개이면 가능.
  // 그래서 마커 인터페이스인 경우에만 가능. ( ex. Serializable, Cloneable 등)
  // 마커 인터페이스는 메소드가 존재하지 않는 interface를 의미
  private static void intersection(Function o) {
  }

  // generic으로도 intersection 사용 가능.
  // Benji Webber 블로그 참고
  private static <T extends Function & Serializable & Cloneable> void genericIntersection(T o) {
  }

  interface Hello {
    // default 메소드는 무조건 public, 필드 사용 못함, static 메소드와 interface의 메소드 호출 가능
    default void hello() {
      System.out.println("Hello");
    }
  }

  interface Hi {
    default void hi() {
      System.out.println("Hi");
    }
  }

  // intersection으로 사용한 모든 interface의 default 메소드를 합쳐서 사용할 수 있다.
  // 하지만 선언부와 호출부에 인터페이스들을 일일이 명시해줘야 한다.
  private static <T extends Function & Serializable & Cloneable & Hello & Hi> void usingDefaultMethod(T o) {
    o.hello();
    o.hi();
  }

  // 선언부에서는 Functioin과 Consumer를 사용하여 호출하는쪽에서 default 메소드를 선택하여 사용할 수 있도록 할 수 있다.
  private static <T extends Function> void usingDefaultMethodByCallback(T t, Consumer<T> consumer) {
    consumer.accept(t);
  }
}
