import java.io.*;


public class Main {
    static int executionCount = 0;
    static int executionCountDP = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fibonacci(N);
        fibonacciDP(N);

        System.out.printf("%d %d", executionCount, executionCountDP);

    }

    static int fibonacci(int n) {

        if (n == 1 || n == 2) {
            executionCount++;
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciDP(int n) {

        int[] f = new int[n + 1];  // 배열 f 선언 (0부터 시작하므로 n+1 크기)
        f[1] = 1;  // f[1] = 1
        f[2] = 1;  // f[2] = 1

        // f[3]부터 f[n]까지 계산
        for (int i = 3; i <= n; i++) {
            executionCountDP++;
            f[i] = f[i - 1] + f[i - 2];  // f[i] = f[i-1] + f[i-2]
        }

        return f[n];  // f[n] 반환
    }
}