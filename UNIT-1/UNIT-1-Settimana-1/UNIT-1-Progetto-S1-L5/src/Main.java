import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < elementi.length ; i++){
                System.out.println("Inserisci il tipo di elemento multimediale (1 = Video, 2 = Registrazione, 3 = Immagine): ");
            int tipo = scanner.nextInt();

            scanner.nextLine();

            System.out.println("titolo");
            String titolo = scanner.nextLine();

            switch (tipo){
                case 1:
                    System.out.println("inserisci luminosita");
                    int luminositaVideo = scanner.nextInt();

                    System.out.println("inserisci la durata ");
                    int durataVideo = scanner.nextInt();

                    System.out.println("inserisci il volume");
                    int volumeVideo = scanner.nextInt();

                    elementi[i] = new Video(titolo,luminositaVideo,durataVideo,volumeVideo);
                    break;


                case 2:
                    System.out.println("inserisci la durata ");
                    int durataRec = scanner.nextInt();

                    System.out.println("inserisci il volume");
                    int volumeRec = scanner.nextInt();

                    elementi[i] = new Registrazione(titolo,durataRec,volumeRec);
                    break;


                case 3 :
                    System.out.println("inserisci luminosita");
                    int luminositaImg = scanner.nextInt();

                    elementi[i] = new Immagini(titolo,luminositaImg);
                    break;
                default:
                    System.out.println("Non Valido");
            }

            int scelta = -1;
            while (scelta != 0){
                System.out.println("Inserisci il numero dell'elemento da eseguire (1-5) o 0 per uscire: ");
                scelta = scanner.nextInt();

                if (scelta >= 1 && scelta <= 5){
                    if (elementi[scelta - 1] instanceof Riproducipile) {
                        ((Riproducipile) elementi[scelta - 1]).play();
                    } else if (elementi[scelta - 1] instanceof Immagini) {
                        ((Immagini) elementi[scelta - 1]).Show();
                    } else {
                        System.out.println("Elemento non riproducibile.");
                    }
                } else if (scelta == 0) {
                    return;
                } else {
                    System.out.println("Scelta non valida.");
                }
                }

            }


        }


    }