package Esercizio1;

public class Main {

    public static void main(String[] args) {

        Dipendente d1 = new DipendenteFullTime("DSADSA",1000,new Dipartimento("PRODUZIONE"));
        Dipendente d2 = new DipendentePartTime("DSADSA",1000,new Dipartimento("PRODUZIONE"));
        Dipendente d3 = new Dirigente("DSADSA",1000,new Dipartimento("PRODUZIONE"));


        Dipendente[] arr = {d1,d2,d3};

        for (Dipendente dipendente : arr){
            dipendente.calculateSalary();
        }

        Volontario volontario = new Volontario("ssdsa",19,"bella");

        Persona[] arr1 = {d1,d2,d3,volontario};

        for (Persona persona : arr1){
            persona.checkIn();
        }

    }
    }

