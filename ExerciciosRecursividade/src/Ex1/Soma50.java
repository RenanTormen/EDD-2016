package Ex1;

public class Soma50 {

    static int num = 50;

    public static void soma(int n) {
        if (n == num) {
            System.out.println("[" + n + "]");
        } else {
            System.out.print(n);
            System.out.println("\n");
            System.out.print("[" + n + "]");
            soma(n + 1);

        }
    }

    public static void main(String[] args) {
        soma(0);
    }
}
