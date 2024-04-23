package Esercizio3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Banca {
    static Logger logger = (Logger) LoggerFactory.getLogger("logger1");

    public static void main(String args[]) {
        logger.info("Sto lanciando l'applicazione");
        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 100);

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

        try {
            conto1.preleva(1000);

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Saldo conto: " + conto1.restituisciSaldo());
        logger.info("Sto lanciando l'applicazione");
    }
}
