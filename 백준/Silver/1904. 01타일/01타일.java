import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacciDP(N));


    }
    public static long fibonacciDP(int n) {

        int[] f = new int[n + 2];  // 배열 f 선언 (1부터 시작하므로 n+2 크기)
        f[1] = 1;  // f[1] = 1
        f[2] = 2;  // f[2] = 1

        // f[3]부터 f[n]까지 계산
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 15746;  // f[i] = f[i-1] + f[i-2]
        }

        return f[n];  // f[n] 반환
    }
}