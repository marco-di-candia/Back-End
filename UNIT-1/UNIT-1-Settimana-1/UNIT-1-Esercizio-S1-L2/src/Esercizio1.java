import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
//        es1();
        anno();
    }

    public static void es1 (){
        Scanner scanner = new Scanner(System.in);

        System.out.println("scrivi una frase");
        String pariDispari = scanner.nextLine();

        int lungezza = pariDispari.length();

        if (lungezza % 2 == 0){
            System.out.println("pari");
        }else{
            System.out.println("dispari");
        }
    }

    public static void anno(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("scrivi l'anno");
        int annoB = scanner.nextInt();

        if (annoB % 4 == 0 && annoB % 100 != 0 || annoB % 400 == 0){
            System.out.println(annoB + " è un anno bisestile.");
        }else{
            System.out.println(annoB + " non è un anno bisestile.");
        }


    }
}
