public class Rettangolo {

    private int altezza;
    private int larghezza;

    public int calcoloArea (){
        return altezza * larghezza;
    }
    public int calcoloPerimetro() {
        return 2 * (altezza + larghezza);
    }

    public Rettangolo (int altezza , int larghezza){
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public void  stampaRettangolo (){
        System.out.println("l'area del perimetro é " + calcoloArea() + calcoloPerimetro());

    }
    public int  stampaDueRettangoli (){
        int somma = 2 * (calcoloArea() + calcoloPerimetro());
          return somma;

    }

    public int getAltezza(){
        return altezza;
    }
    public int getLarghezza(){
        return larghezza;
    }
}



















