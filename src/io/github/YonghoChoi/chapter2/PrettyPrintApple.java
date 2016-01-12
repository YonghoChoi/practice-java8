package io.github.YonghoChoi.chapter2;

import java.util.List;

public class PrettyPrintApple {
    public void filterToString(List<Apple> inventory, PreetyPrint p) {
        for(Apple apple : inventory) {
            System.out.println(p.print(apple));
        }
    }
}

interface PreetyPrint {
    String print(Apple apple);
}

class PrettyPrintColorAndWeight implements PreetyPrint {
    @Override
    public String print(Apple apple) {
        return "color : " + apple.getColor() + ", weight : " + apple.getWeight();
    }
}

class PrettyPrintCompareWeight150 implements PreetyPrint {
    @Override
    public String print(Apple apple) {
        if(apple.getWeight() > 150) {
            return apple.getColor() + "is big.";
        } else {
            return apple.getColor() + "is small.";
        }
    }
}
