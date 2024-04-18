package Esercizio1;

public class DipendentePartTime extends Dipendente {

    public DipendentePartTime(String matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }
    @Override
    public void calculateSalary(){
        System.out.println(stipendio / 2);
    }
}
