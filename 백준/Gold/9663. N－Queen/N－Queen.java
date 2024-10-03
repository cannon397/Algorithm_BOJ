import java.io.*;
import java.util.*;
//너무 어렵다.
public class Main {

    static int N;
    static int answer = 0;
    static boolean[] cols;         // 각 열에 퀸이 있는지 기록
    static boolean[] diagonal1;     // 좌측 대각선 (row - col)이 있는지 기록
    static boolean[] diagonal2;     // 우측 대각선 (row + col)이 있는지 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cols = new boolean[N];           // 열 기록 배열
        diagonal1 = new boolean[2 * N];  // 좌측 대각선 기록 배열
        diagonal2 = new boolean[2 * N];  // 우측 대각선 기록 배열

        dfs(0);  // 0번째 행부터 탐색 시작
        System.out.println(answer);
    }

    static void dfs(int row) {
        if (row == N) {  // N개의 퀸을 모두 배치한 경우
            answer++;    // 경우의 수 증가
            return;
        }

        for (int col = 0; col < N; col++) {
            int d1 = row - col + N;
            int d2 = row + col;
            if (cols[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;  // 열, 좌측 대각선, 우측 대각선에 이미 퀸이 있으면 넘어감
            }

            cols[col] = true;
            diagonal1[d1] = true;  // 좌측 대각선
            diagonal2[d2] = true;      // 우측 대각선

            dfs(row + 1);  // 다음 행으로 이동

            // 재귀 호출이 끝난 뒤 퀸을 제거 (백트래킹)
            cols[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}