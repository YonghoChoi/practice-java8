package chap08;

import org.junit.Test;

public class AnonymousToLamdaTest {
  @Test
  public void testAnonymous() {
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello");
      }
    };

    r1.run();
  }

  @Test
  public void testLamda() {
    Runnable r1 = () -> System.out.println("Hello");

    r1.run();
  }

  @Test
  public void testAnonymousShadowVariable() {
    int a = 10;
//    Runnable r1 = () -> {
//      int a = 2;
//      System.out.println(a);
//    };

    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        int a = 2;
        System.out.println(a);
      }
    };
  }

  public static void doSomething(Runnable r) { r.run(); }
  public static void doSomething(Task a) { a.execute(); }

  @Test
  public void testAmbitiousAnonimous() {
    doSomething(new Task() {
      @Override
      public void execute() {
        System.out.println("Danger danger!!");
      }
    });
  }

  @Test
  public void testAmbitiousLamda() {
    doSomething((Task)() -> System.out.println("Danger danger!!"));
  }
}


interface Task{
  void execute();
}