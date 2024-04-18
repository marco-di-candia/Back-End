import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     Rettangolo rettangolo = new Rettangolo(4,6);
        System.out.println("l'area del rettangolo é "+ rettangolo.calcoloArea() + " il perimetro del rettangolo é " +rettangolo.calcoloPerimetro());


        Rettangolo rettangolo2 = new Rettangolo(5 , 6);

        System.out.println(rettangolo2.stampaDueRettangoli());

//        chiamate


        Scanner scanner = new Scanner(System.in);


        System.out.print("Inserisci Numero Di Cellulare: ");
        int cell = scanner.nextInt();

        System.out.print("Fai una Ricarica: ");
        double ricarica = scanner.nextDouble();

        Sim sim = new Sim(cell,ricarica);


        System.out.println("Cell: " + sim.getNumero());
        System.out.println("Credito: " + sim.getcredito());

        System.out.print("Inserire Costo Chiamata: ");
        double costoChiamata = scanner.nextDouble();

        int costoCentesimi = (int) (costoChiamata);
        if (sim.chiamata(costoCentesimi)){
            System.out.println("Chiamata effettuata con successo! ");
        }else{
            System.out.println("Credito insufficiente per effettuare la chiamata. ");
        }


        System.out.println("Credito: " + sim.getcredito());


    }
}
