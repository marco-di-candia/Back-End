package Esercizio1;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }
    @Override
    public void calculateSalary(){
        System.out.println(stipendio / 12);
    }
}
