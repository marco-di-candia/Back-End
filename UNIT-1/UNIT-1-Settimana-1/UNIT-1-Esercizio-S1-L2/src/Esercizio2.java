import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
    swit();
    }

    public static void swit(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("scrivi un numero");
        int numero = scanner.nextInt();

        switch (numero){
            case 0:
            System.out.println("valido: zero");
                break;
            case 1:
                System.out.println("valido: uno");
            break;
            case 2:
                System.out.println("valido: due");
            break;
            case 3:
                System.out.println("valido: tre");
            break;
            default:
                System.out.println("numero non valido");
        }

    }
}
