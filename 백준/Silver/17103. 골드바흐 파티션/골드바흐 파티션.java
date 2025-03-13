import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        int[] answer = new int[T];
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int j = 2; j * j < isPrime.length; j++) {
            if (isPrime[j]) {
                for (int k = j * j; k < isPrime.length; k += j) {
                    isPrime[k] = false;
                }
            }
        }
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            for (int j = 2; j <= N / 2; j++) {
                if(isPrime[j] && isPrime[N - j]){
                    answer[i]++;
                }
            }
        }
        for (int number : answer) {
            System.out.println(number);
        }
    }
}