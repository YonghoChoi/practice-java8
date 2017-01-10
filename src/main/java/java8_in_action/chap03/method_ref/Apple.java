package java8_in_action.chap03.method_ref;

public class Apple {
    String name;
    Integer weight;

    public Apple(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
