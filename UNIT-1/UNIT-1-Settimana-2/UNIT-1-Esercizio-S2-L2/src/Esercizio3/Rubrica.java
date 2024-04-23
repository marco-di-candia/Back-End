package Esercizio3;

import java.util.HashMap;
import java.util.Set;

public class Rubrica {
    private HashMap<String, String> rubrica;

    public Rubrica (){
        rubrica = new HashMap<>();
    }

    public void inserisciContatto(String nome , String numero){
        rubrica.put(nome,numero);
    }

    public void rimotiContato(String nome){
        rubrica.remove(nome);
    }

    public String carcaPernome(String nome){
        return rubrica.get(nome);
    }

    public String carcaPerCell(String numero){
        Set<String> nomi = rubrica.keySet();

        for(String nome : nomi){
            String numeCell = rubrica.get(nome);

            if (numeCell.equals(numero)){
                return nome;
            }
        }
        return null;
    }
    public void stampa(){
        System.out.println(rubrica);
    }
}
