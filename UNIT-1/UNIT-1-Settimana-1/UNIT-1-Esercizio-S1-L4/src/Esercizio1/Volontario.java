package Esercizio1;

public class Volontario extends Persona {

    private String nome;
    private int eta;
    private String cv;

    public Volontario(String cv, int eta, String nome) {
        this.cv = cv;
        this.eta = eta;
        this.nome = nome;
    }

    public String getNome (){
        return this.nome;
    }
    public int eta (){
        return this.eta;
    }
    public String cv (){
        return this.cv;
    }

    @Override
    public void checkIn() {
        System.out.println("Lovoro Gratis");
    }
}
