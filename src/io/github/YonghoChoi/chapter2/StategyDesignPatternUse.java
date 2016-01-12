package io.github.YonghoChoi.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 전략 패턴 (Stategy Design Pattern)을 사용하여 자바8 문법을 사용하지 않고 유연하게 필터링 구현
 */
public class StategyDesignPatternUse {
    public List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

interface ApplePredicate {
    boolean test(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}

class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
