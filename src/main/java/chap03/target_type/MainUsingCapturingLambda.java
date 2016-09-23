package chap03.target_type;

public class MainUsingCapturingLambda {
    public static void main(String[] args) {
        int portNumber = 1337;
        run(() -> System.out.println(portNumber));
    }

    public static void run(Runnable r) {
        r.run();
    }
}
