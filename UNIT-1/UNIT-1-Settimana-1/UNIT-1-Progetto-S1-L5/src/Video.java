public class Video extends ElementoMultimediale implements Riproducipile {
    private int luminosita;
    private int durata;
    private int volume;

    public Video(String titolo, int durata, int luminosita, int volume) {
        super(titolo);
        this.durata = durata;
        this.luminosita = luminosita;
        this.volume = volume;
    }

    public int getDurata() {
        return durata;
    }

    @Override
    public void play() {
        for (int i = 0 ; i < durata ; i++){
            for (int j = 0 ; j < volume ; j++){
                System.out.println("!");
            }
            for (int l = 0; l < luminosita ; l++){
                System.out.println("*");
            }
            System.out.println(" " + titolo);
        }

    }

    public void alzaLuminosita(){
        luminosita ++;
    }

    public void abbassaLuminosita(){
        if (luminosita > 0 ){
            luminosita --;
        }
    }
}
