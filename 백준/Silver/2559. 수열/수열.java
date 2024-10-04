import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] prefixSum = new int[N - K + 1];
        for (int i = 0; i < K; i++) {
            prefixSum[0] += array[i];
        }
        for (int i = K; i <= N - 1; i++) {
                prefixSum[i - K + 1] = prefixSum[i - K] + array[i] - array[i - K];
        }
        System.out.println(Arrays.stream(prefixSum).max().getAsInt());
    }
}