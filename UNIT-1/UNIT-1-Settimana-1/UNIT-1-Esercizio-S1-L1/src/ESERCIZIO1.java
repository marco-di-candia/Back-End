import java.util.Arrays;

public class ESERCIZIO1 {
    public static void main(String[] args) {

        int a = 4;
        int b = 12;
        int result = somma(5,5);
        System.out.println(result);


        System.out.println( "hello world" + " " + 50);


        String[] arr = newArray(new String[]{"1","2","3","4","5"},"stringa");
        System.out.println(Arrays.toString(arr));


    }

    public static int somma (int a ,int b){
        return a * b;
    }
    public static String concat (String s ,int numero){
        return s + numero;
    }

    public static String[] newArray(String[] sArray, String s){
        String[] arr = new String[6];
        for(int i = 0; i < sArray.length +1 ; i++){
            if (i < 2){
                arr[i] = sArray[i];
            }else if (i == 2){
                arr[i] = s;
            }else {
                arr[i] = sArray[i - 1];
            }
        }
        return arr;
    }
}
