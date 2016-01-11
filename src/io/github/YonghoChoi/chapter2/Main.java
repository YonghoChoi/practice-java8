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
        OriginJavaCase();
    }

    private static void OriginJavaCase() {
        List<Apple> farmProducts = new ArrayList<Apple>();
        farmProducts.add(new Apple("green"));
        farmProducts.add(new Apple("yellow"));
        farmProducts.add(new Apple("red"));
        farmProducts.add(new Apple("blue"));

        OriginJavaCase origin = new OriginJavaCase();

        StringBuilder sb = new StringBuilder();
        List<Apple> result = origin.filterGreenApples(farmProducts);
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }

        System.out.println("origin result : " + sb.toString());
    }
}
