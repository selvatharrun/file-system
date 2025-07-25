public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int sum = add(x, y);  // <— put breakpoint here
        System.out.println("Sum: " + sum);
    }

    static int add(int a, int b) {
        return a + b;
    }
}
