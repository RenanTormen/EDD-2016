package Ex2;

import javax.swing.JOptionPane;

public class Ex2 {

    static int res;

    public static int fatorial(int n) {

        if (n <= 1) {
            return n;
        } else {
            System.out.println(n);
            return fatorial(n - 1) * n;
        }
    }

    public static void main(String[] args) {

        int user = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um numero: "));
        System.out.println(fatorial(user));
    }
}
