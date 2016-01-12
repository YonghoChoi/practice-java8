package io.github.YonghoChoi.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * java8 in action의 Chapter2 동작 파라미터에 대한 내용입니다
     *
     * 예제의 내용
     *  - 농장 재고 목록 애플리케이션
     *  - 기존 자바 방식, 익명 클래스 사용, 람다 사용 이렇게 세가지 방식으로 구현
     * @param args
     */
    public static void main(String[] args) {
        List<Apple> farmProducts = new ArrayList<Apple>();
        farmProducts.add(new Apple("green", 105));
        farmProducts.add(new Apple("yellow", 200));
        farmProducts.add(new Apple("red", 300));
        farmProducts.add(new Apple("blue", 150));

        OriginJavaCase(farmProducts);
        StategyDesignPatternUse(farmProducts);
        PrettyPrintExam(farmProducts);
    }

    private static void OriginJavaCase(List<Apple> farmProducts) {
        OriginJavaUse origin = new OriginJavaUse();

        StringBuilder sb = new StringBuilder();
        List<Apple> result = origin.filterGreenApples(farmProducts);
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }

        System.out.println("filterGreenApples result : " + sb.toString());

        result.clear();
        sb.delete(0, sb.length());
        result = origin.filterAppleByColor(farmProducts, "green");
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }

        System.out.println("filterAppleByColor result : " + sb.toString());

        result.clear();
        sb.delete(0, sb.length());
        result = origin.filterApplesByWeight(farmProducts, 150);
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }

        System.out.println("filterApplesByWeight result : " + sb.toString());
    }

    private static void StategyDesignPatternUse(List<Apple> farmProducts) {
        StategyDesignPatternUse stategy = new StategyDesignPatternUse();
        List<Apple> result = stategy.filter(farmProducts, new AppleHeavyWeightPredicate());

        StringBuilder sb = new StringBuilder();
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }
        System.out.println("AppleHeavyWeightPredicate result : " + sb.toString());

        result = stategy.filter(farmProducts, new AppleGreenColorPredicate());
        sb.delete(0, sb.length());
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }
        System.out.println("AppleGreenColorPredicate result : " + sb.toString());
    }

    private static void PrettyPrintExam(List<Apple> farmProducts) {
        PrettyPrintApple prettyPrint = new PrettyPrintApple();
        System.out.println("== Pretty Print Color And Weight ==");
        prettyPrint.filterToString(farmProducts, new PrettyPrintColorAndWeight());

        System.out.println("== Pretty Print Big or Small ==");
        prettyPrint.filterToString(farmProducts, new PrettyPrintCompareWeight150());
    }
}
