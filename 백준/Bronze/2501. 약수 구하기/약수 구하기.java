import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = numbers[0];
        int K = numbers[1];
        int flag = 0;
        for (int i = 1; i <= N; i++) {
            if(N % i == 0) flag++;
            if(flag == K) {
                System.out.println(i);
                break;
            }
        }
        if(flag != K){
            System.out.println(0);
        }
    }
}