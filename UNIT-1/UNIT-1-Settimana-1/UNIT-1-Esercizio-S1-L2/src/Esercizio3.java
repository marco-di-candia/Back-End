import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        es3();
    }

    public static void es3 (){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scrivi una Frase Exit(:q)");
        String string = scanner.nextLine();


        while (!string.equals(":q")){
            System.out.println("Scrivi una Frase Exit(:q)");
            string = scanner.nextLine();
        }
        System.out.println("Hai scelto di uscire");
    }
}
