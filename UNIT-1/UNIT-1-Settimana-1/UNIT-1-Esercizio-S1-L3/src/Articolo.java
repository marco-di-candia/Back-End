public class Articolo {
    private String codice;
    private String prezzo;
    private String numeroPrezzi;


    public String getCodice() {
        return codice;
    }

    public String getNumeroPrezzi() {
        return numeroPrezzi;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public Articolo(String codice, String numeroPrezzi, String prezzo) {
        this.codice = codice;
        this.numeroPrezzi = numeroPrezzi;
        this.prezzo = prezzo;
    }

}
