
public class Sim {
    private int numero;
    private double credito;
    private Chiamata[] chiamata;

    public Sim (int numero , double credito){
        this.numero = numero;
        this.credito = credito;
    }

    public int getNumero(){
        return numero;
    }

    public double getcredito(){
        return credito;
    }


    public void ricarica (double soldi ){
        this.credito += soldi;
    }
    public boolean chiamata(double costoChiamata) {
        if (costoChiamata <= credito) {
            credito -= costoChiamata;
            return true;
        } else {
            return false;
        }
    }


}
