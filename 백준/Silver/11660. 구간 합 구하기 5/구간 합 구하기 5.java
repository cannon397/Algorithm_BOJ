import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//누적합 DP 배열을 만들어서 각 행별로 누적합을 구해야함
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = condition[0];
        int M = condition[1];
        int[][] table = new int[N + 1][N + 1];
        int[][] positionXY = new int[M][4];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < position.length; j++) {
                table[i][j + 1] = position[j];
            }
        }

        for (int i = 1; i < table.length; i++) {
            int nu = 0;
            for (int j = 1; j < table[i].length; j++) {
                dp[i][j] = nu + table[i][j];
                nu += table[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            positionXY[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < M; i++) {
            int answer = 0;
            for (int j = positionXY[i][0]; j <= positionXY[i][2]; j++) {
                answer += dp[j][positionXY[i][3]] - dp[j][positionXY[i][1] - 1];
            }

            System.out.println(answer);
        }
    }
}