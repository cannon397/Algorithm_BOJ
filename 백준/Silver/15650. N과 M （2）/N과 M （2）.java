import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int M;
    static int N;
    static int[] A;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        N = Integer.parseInt(number[0]);
        M = Integer.parseInt(number[1]);
        A = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(0);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for (String item : list){
            sb.append(item).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int index) {
        if (index == M) {
            StringBuilder tempSB = new StringBuilder();
            int[] tempArray = new int[M];
            for (int i = 0; i < M; i++) {
                tempArray[i] = A[i];
            }
            Arrays.sort(tempArray);
            for (int i = 0; i < M; i++) {
                tempSB.append(tempArray[i]).append(" ");
            }
            set.add(tempSB.toString());
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