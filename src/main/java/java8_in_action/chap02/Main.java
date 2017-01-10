package java8_in_action.chap02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * java8 in action의 Chapter2 동작 파라미터에 대한 내용입니다
     *
     * 예제의 내용
     *  - 농장 재고 목록 애플리케이션
     *  - 기존 자바 방식, 익명 클래스, 람다를 사용하여 구현
     *
     * 메서드 설명
     *  OriginJavaCase() : 기존 자바 방식
     *  StategyDesignPatternUse() : 전략 패턴 사용
     *  PrettyPrintExam() : java8 in action 책의 중간 예제
     *  AnonymousClassUse() : 익명 클래스 사용
     *  AnonymousGenericClassUse() : 익명 제네릭 클래스 사용
     *  AnonymousGenericClassToLamda() : 익명 제네릭 클래스를 람다로 변경
     *
     * @param args
     */
    private static List<Apple> farmProducts = new ArrayList<Apple>();
    public static void main(String[] args) {
        farmProducts.add(new Apple("green", 105));
        farmProducts.add(new Apple("yellow", 200));
        farmProducts.add(new Apple("red", 300));
        farmProducts.add(new Apple("blue", 150));

        OriginJavaCase();
        StategyDesignPatternUse();
        PrettyPrintExam();
        AnonymousClassUse();
        AnonymousGenericClassUse();
        AnonymousGenericClassToLamda();
    }

    private static void OriginJavaCase() {
        OriginJavaUse origin = new OriginJavaUse();

        List<Apple> result = origin.filterGreenApples(farmProducts);
        PrintResult(result, "filterGreenApples");

        result = origin.filterAppleByColor(farmProducts, "green");
        PrintResult(result, "filterAppleByColor");

        result = origin.filterApplesByWeight(farmProducts, 150);
        PrintResult(result, "filterApplesByWeight");
    }

    private static void StategyDesignPatternUse() {
        StategyDesignPatternUse stategy = new StategyDesignPatternUse();
        List<Apple> result = stategy.filter(farmProducts, new AppleHeavyWeightPredicate());
        PrintResult(result, "AppleHeavyWeightPredicate");

        result = stategy.filter(farmProducts, new AppleGreenColorPredicate());
        PrintResult(result, "AppleGreenColorPredicate");
    }

    private static void PrettyPrintExam() {
        PrettyPrintApple prettyPrint = new PrettyPrintApple();
        System.out.println("== Pretty Print Color And Weight ==");
        prettyPrint.filterToString(farmProducts, new PrettyPrintColorAndWeight());

        System.out.println("== Pretty Print Big or Small ==");
        prettyPrint.filterToString(farmProducts, new PrettyPrintCompareWeight150());
    }

    private static void AnonymousClassUse() {
        AnonymousClassUse anonymous = new AnonymousClassUse();
        List<Apple> result = anonymous.filter(farmProducts, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        });
        PrintResult(result, "AppleGreenColorAnonymousClass");

        result = anonymous.filter(farmProducts, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        PrintResult(result, "AppleHeavyWeightAnonymousClass");
    }

    private static void AnonymousGenericClassUse() {
        AnonymousGenericClassUse generic = new AnonymousGenericClassUse();
        List<Apple> result = generic.filter(farmProducts, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        });
        PrintResult(result, "AppleGreenColorAnonymousGenericClass");

        result = generic.filter(farmProducts, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        PrintResult(result, "AppleHeavyWeightAnonymousGenericClass");
    }

    private static void AnonymousGenericClassToLamda() {
        AnonymousGenericClassUse generic = new AnonymousGenericClassUse();
        List<Apple> result = generic.filter(farmProducts, apple -> apple.getColor().equals("green"));
        PrintResult(result, "AppleGreenColorLamda");

        result = generic.filter(farmProducts, apple -> apple.getWeight() > 150);
        PrintResult(result, "AppleHeavyWeightLamda");
    }

    private static void PrintResult(List<Apple> result, String msg) {
        StringBuilder sb = new StringBuilder();
        for(Apple apple : result) {
            sb.append(apple.getColor() + " ");
        }
        System.out.println(msg + " result : " + sb.toString());
    }
}
