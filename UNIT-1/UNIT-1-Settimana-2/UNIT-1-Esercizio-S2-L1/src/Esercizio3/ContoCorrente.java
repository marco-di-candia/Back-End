package Esercizio3;

public class ContoCorrente {
    String titolare;
    int nMovimenti;
    final int maxMovimenti = 50;
    double saldo;

    ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        nMovimenti = 0;
    }

    void preleva(double x) throws Exception {
        if (nMovimenti < maxMovimenti) {
            if (x > saldo){
                System.out.println("Prelievo superiore al saldo disponibile");
            }else {
                saldo -= x;
                System.out.println("Prelievo avvenuto con successo.");
            }
        } else {
            if (x + 0.50 <= saldo) {
                saldo -= (x + 0.50);
                nMovimenti++;
            } else {
                throw new Exception("Prelievo superiore al saldo disponibile");
            }
        }
    }




    double restituisciSaldo() {
        return saldo;
    }
}