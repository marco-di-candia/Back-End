public class Registrazione extends ElementoMultimediale implements Riproducipile {

    private int volume;
    private int durata;


    public Registrazione(String titolo,int volume,int durata) {
        super(titolo);
        this.volume = volume;
        this.durata = durata;
    }

    public int getDurata() {
        return this.durata;
    }

    public void alzaVolume(){
        this.volume++;
    }

    public void AbbasaVolume(){
        if (this.volume > 0 ){
            this.volume --;
        }
    }
     @Override
    public void play(){
        for (int i = 0 ; i < durata ; i++){
            for (int j = 0 ; j < volume ; j++){
                System.out.println("!");
            }
            System.out.println(" " + titolo);

         }
    }

}