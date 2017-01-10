package chap08;

import java.util.ArrayList;
import java.util.List;

public class NewsTweet {
  public static void main(String[] args) {
    Feed f = new Feed();
//    f.registerObserver(new NYTimes());
//    f.registerObserver(new Guardian());
//    f.registerObserver(new Lemonde());
    f.registerObserver((String tweet) -> {
      if (tweet != null && tweet.contains("money")) {
        System.out.println("Breaking news in NY! " + tweet);
      }
    });
    f.registerObserver((String tweet) -> {
      if (tweet != null && tweet.contains("queen")) {
        System.out.println("Yet another news in London... " + tweet);
      }
    });
    f.registerObserver((String tweet) -> {
      if (tweet != null && tweet.contains("wine")) {
        System.out.println("Today cheese, wine and news! " + tweet);
      }
    });
    f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
  }
}

interface Observer {
  void notify(String tweet);
}

class NYTimes implements Observer {
  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("money")) {
      System.out.println("Breaking news in NY! " + tweet);
    }
  }
}

class Guardian implements Observer {
  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("queen")) {
      System.out.println("Yet another news in London... " + tweet);
    }
  }
}

class Lemonde implements Observer {
  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("wine")) {
      System.out.println("Today cheese, wine and news! " + tweet);
    }
  }
}

interface Subject {
  void registerObserver(Observer o);

  void notifyObservers(String tweet);
}

class Feed implements Subject {
  private final List<Observer> observers = new ArrayList<>();

  public void registerObserver(Observer o) {
    this.observers.add(o);
  }

  @Override
  public void notifyObservers(String tweet) {
    observers.forEach(o -> o.notify(tweet));
  }
}