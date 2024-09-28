import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cards = br.readLine().split(" ");
        int N = Integer.parseInt(cards[0]);
        int M = Integer.parseInt(cards[1]);
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        int temp = 0;

        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    sum = numbers[i] + numbers[j] + numbers[k];
                    if(sum == M){
                        System.out.println(M);
                        return;
                    }
                    if(M > sum && sum > temp){
                        temp = sum;
                    }
                }
            }
        }
        System.out.println(temp);
    }
}