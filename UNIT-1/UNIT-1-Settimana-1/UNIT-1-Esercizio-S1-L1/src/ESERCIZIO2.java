import java.util.Scanner;

public class ESERCIZIO2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = new String[3];
        System.out.println("Inserisci il Nome:");
        array[0] = scanner.nextLine();

        System.out.println("Inserisci il Cognome:");
        array[1] = scanner.nextLine();

        System.out.println("Inserisci il Paese:");
        array[2] = scanner.nextLine();


        System.out.println("risultato é" +  " " + "Nome:"+ " " + array[0]  +  " " + "Cognome:" + " "+ array[1] +  " " + "Paese:"+ " "+ array[2]);

        System.out.println("risultato é" +  " " + "Paese:"+ " " + array[2]  +  " " + "Cognome:" + " "+ array[1] +  " " + "Nome:"+ " "+ array[0]);

    }
}
