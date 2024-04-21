public class Immagini extends ElementoMultimediale {
    private int luminosita;

    public Immagini(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void Show(){
        for (int l = 0; l < luminosita ; l++){
            System.out.println("*");
        }
        System.out.println(" " + titolo);
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }
}
