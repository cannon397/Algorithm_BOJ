import java.io.*;
import java.util.*;


public class Main {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int M;
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        N = Integer.parseInt(number[0]);
        M = Integer.parseInt(number[1]);
        A = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                sb.append(A[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                A[index] = i;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
}