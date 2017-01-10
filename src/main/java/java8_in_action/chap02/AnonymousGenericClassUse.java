package java8_in_action.chap02;

import java.util.ArrayList;
import java.util.List;

public class AnonymousGenericClassUse {
    public <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for(T t : inventory) {
            if(p.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
