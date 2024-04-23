import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainEs1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero di parole: ");
        int numero = scanner.nextInt();

        Set<String> parole = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();



        for (int i = -1; i < numero; i++) {

            String parola = scanner.nextLine().trim();
            System.out.println("Inserisci le parole:");

            parole.add(parola);
            if (!parole.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }

        System.out.println("Parole duplicate:");
        System.out.println(parole);


        System.out.println("Numero di parole distinte: " + parole.size());


        System.out.println("Elenco delle parole distinte:");
        System.out.println(parole);


        scanner.close();
    }


    }