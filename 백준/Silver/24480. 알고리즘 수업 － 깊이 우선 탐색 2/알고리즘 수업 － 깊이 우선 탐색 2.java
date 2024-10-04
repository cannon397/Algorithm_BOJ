import java.io.*;
import java.util.*;


public class Main {
    static int[] order;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        order = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(line.nextToken());
            int v = Integer.parseInt(line.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (ArrayList<Integer> v : graph) {
            v.sort(Collections.reverseOrder());
        }
        dfs(graph, R);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(ArrayList<ArrayList<Integer>> V, int R) {
        order[R] = count++;
        for (int x : V.get(R)) {
            if (order[x] == 0) {
                dfs(V, x);
            }
        }
    }
}