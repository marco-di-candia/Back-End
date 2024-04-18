package Esercizio1;

public class Dirigente extends Dipendente{

    public Dirigente(String matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }
    @Override
    public void calculateSalary(){
        System.out.println((stipendio) / 12 / 2);
    }
}
