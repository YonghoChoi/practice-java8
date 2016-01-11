package io.github.YonghoChoi.chapter2;

import java.util.ArrayList;
import java.util.List;

public class OriginJavaCase {
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }
}

class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}