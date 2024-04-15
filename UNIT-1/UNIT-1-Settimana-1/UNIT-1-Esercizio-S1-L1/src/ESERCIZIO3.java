public class ESERCIZIO3 {
    public static void main(String[] args) {
        System.out.println(primo(10, 10.5));
        System.out.println(secondo(27));
    }

    public static double primo(double n1, double n2) {
        return n1 + n2;
    }

    public static String secondo(int n3) {
        if (n3 % 2 == 0) {
            return "Pari";
        } else {
            return "Dispari";
        }
    }
}
