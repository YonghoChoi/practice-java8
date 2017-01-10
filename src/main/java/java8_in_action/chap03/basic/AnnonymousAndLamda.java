package java8_in_action.chap03.basic;

interface Identity {
    public void print(String type);
}

public class AnnonymousAndLamda {
    public static void main(String[] args) {
        print("익명 클래스", new Identity() {
            @Override
            public void print(String type) {
                System.out.println(type + " 입니다.");
            }
        });

        print("람다", (String type) -> System.out.println(type + " 입니다."));
    }

    private static void print(String type, Identity arg) {
        arg.print(type);
    }
}
