import java.io.*;
import java.util.*;

public class Main {
    static int[] order;
    static int count = 1;
    static Queue<Integer> q;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        order = new int[N + 1];
        graph = new ArrayList<>();
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
            v.sort(Comparator.reverseOrder());
        }

        bfs(R);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++){
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int R){
        q.offer(R);
        order[R] = count++;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if(order[v] == 0){
                    order[v] = count++;
                    q.offer(v);
                }
            }
        }
    }
}