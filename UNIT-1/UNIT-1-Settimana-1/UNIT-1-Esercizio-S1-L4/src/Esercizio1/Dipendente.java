package Esercizio1;

abstract public class Dipendente  extends Persona{
    protected String matricola;
    protected double stipendio;
    protected Dipartimento dipartimento;



    public Dipendente (String matricola, double stipendio, Dipartimento dipartimento ){
        this.matricola=matricola;
        this.stipendio=stipendio;
        this.dipartimento= new Dipartimento(dipartimento.getNomeDipartimento());
    }

    public String getMatricola() {
        return this.matricola;
    }

    public double getStipendio() {
        return this.stipendio;
    }

    public String getDipartimento() {
        return this.dipartimento.getNomeDipartimento();
    }

    public void setDipartimento( Dipartimento dipartimento){
        this.dipartimento.setNomeDipartimento(dipartimento.getNomeDipartimento());
    }

    abstract public void calculateSalary ();


    @Override
    public void checkIn() {
        System.out.println("Lavoro come Dipendente");
    }
}
