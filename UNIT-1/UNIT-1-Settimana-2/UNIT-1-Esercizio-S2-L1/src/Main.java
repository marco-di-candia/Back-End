import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {


        int[] arrRandom = RandomMetod.randomMetod(1);
        try {
            for (int cicla : arrRandom){
                System.out.println(cicla);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println();

        ChilometriPerlitro consumo = new ChilometriPerlitro();
       try {
           System.out.println("il consumo e");
           System.out.println(consumo.calcolo(10,0));
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

    }


}
