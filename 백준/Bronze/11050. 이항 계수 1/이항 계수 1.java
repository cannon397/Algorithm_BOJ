import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        System.out.println(factorial(N, K));
    }
    static int factorial(int N, int K){
        if(N == K || K == 0){
            return 1;
        }
        return factorial(N - 1, K - 1) + factorial(N - 1, K);
    }
}