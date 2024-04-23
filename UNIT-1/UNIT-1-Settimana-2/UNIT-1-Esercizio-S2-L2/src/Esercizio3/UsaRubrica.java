package Esercizio3;

public class UsaRubrica {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();

        rubrica.inserisciContatto("marco","1211242141");
        rubrica.inserisciContatto("mario","35254643634");
        rubrica.inserisciContatto("rossi","12112497896");
        rubrica.inserisciContatto("antonio","01854820244");

        rubrica.stampa();


        System.out.println( rubrica.carcaPerCell("1211242141"));
        System.out.println( rubrica.carcaPernome("mario"));


        rubrica.rimotiContato("antonio");

        rubrica.stampa();
    }
}
