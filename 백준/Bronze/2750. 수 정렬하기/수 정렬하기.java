import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        for (int number : array){
            System.out.println(number);
        }

    }
}