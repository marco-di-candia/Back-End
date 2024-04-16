import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {
    es4();
    }

    public static void es4(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("CountDown Dell Tuo Numero");
        int numero = scanner.nextInt();

        for (int i = numero; i >= 0; i--)
            System.out.println(i);
    }
}
