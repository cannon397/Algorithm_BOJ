import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] S;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][];
        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[N];

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int depth,int idx) {
        if (depth == N / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if(visited[i] && visited[j]){
                        start += S[i][j];
                        start += S[j][i];
                    } else if(!visited[i] && !visited[j]){
                        link += S[i][j];
                        link += S[j][i];
                    }
                }
            }
            int value = Math.abs(start - link);
            if(value == 0){
                System.out.println(0);
                System.exit(0);
            }
            min = Math.min(min, value);
            return;
        }
        for (int i = idx; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}