package io.github.YonghoChoi.chapter2;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClassUse {
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

