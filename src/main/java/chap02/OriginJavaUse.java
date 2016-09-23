package chap02;

import java.util.ArrayList;
import java.util.List;

/**
 * 요구 사항에 따라 비교 조건을 추가 했더니 중복된 코드가 만들어졌다.
 * 기존 자바의 방식으로는 반복문을 통해 해당 조건을 만족하는 요소를 검사하는 것이 불가피하다.
 * 그러므로 각 조건을 검사하기 위한 중복 코드를 제거할 수가 없다.
 * 중복을 제거한다고 모든 조건을 하나의 메서드에 통합한다면 매우 지저분한 코드가 된다.(filterApples 메서드)
 */
public class OriginJavaUse {
    // inventory에서 green 색상을 가진 사과만 필터링
    public List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    // 조금 더 유연하게 inventory에서 입력받은 색상에 대한 사과를 필터링
    public List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    // 입력받은 무게를 기준으로 무거운 사과를 필터링 할 수 있도록 요구사항 추가
    public List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    // 중복 코드를 제거하기 위해 모든 조건을 인자로 받고 flag로 이를 구분함.
    // flag가 true이면 color 조건 검사, false이면 weight 조건 검사.
    public List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(flag == true) {
                if(apple.getColor().equals(color)) {
                    result.add(apple);
                }
            } else {
                if(apple.getWeight() > weight) {
                    result.add(apple);
                }
            }
        }

        return result;
    }
}