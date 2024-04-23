package Esercizio2;


import java.util.*;

public class MainEs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("numero");
        int num = scanner.nextInt();
        ArrayList<Integer> lista = generaNumeroCasuale(num);

        System.out.println(lista);

        System.out.println("lsita Modificata");
        System.out.println(crea(lista));
    }

    public static ArrayList<Integer> generaNumeroCasuale(int n) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lista.add(new Random().nextInt(0, 101));
        }
        Collections.sort(lista);
        return lista;
    }

    public static ArrayList<Integer> crea(ArrayList<Integer> lista){
        ArrayList<Integer> listaModificata = new ArrayList<>();

        listaModificata.addAll(lista);

        Collections.reverse(lista);

        listaModificata.addAll(lista);

        return listaModificata;
    }

    
}
