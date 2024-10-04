import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 누적합 배열 생성
        int[] prefixSum = new int[N + 1];  // 1-based index로 사용하기 위해 N+1 크기
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }
        String line;
        while ((line = br.readLine()) != null) {
            int[] number = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int i = number[0];
            int j = number[1];
            int answer = prefixSum[j] - prefixSum[i - 1];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}