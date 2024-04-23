import java.util.Random;

public class RandomMetod {
    public static int[] randomMetod(int count) throws Exception{
        if (count  == 0){
            throw new Exception ("il numero deve essere maggiore di 0");
        }
        int[] randomNum =new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++){
            randomNum[i] = random.nextInt(6);
        }
        return randomNum;
    }
}
