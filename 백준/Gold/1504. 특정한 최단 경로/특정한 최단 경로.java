import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 경로 계산
        long path1_v1 = dijkstra(1, v1);
        long path1_v2 = dijkstra(1, v2);
        long path_v1_v2 = dijkstra(v1, v2);
        long path_v2_N = dijkstra(v2, N);
        long path_v1_N = dijkstra(v1, N);

        // 두 가지 경로 계산
        long result1 = path1_v1 + path_v1_v2 + path_v2_N;
        long result2 = path1_v2 + path_v1_v2 + path_v1_N;

        // 더 짧은 경로 선택
        long result = Math.min(result1, result2);

        // 경로가 존재하지 않는 경우 처리
        if (result == Integer.MAX_VALUE || path1_v1 == -1 || path1_v2 == -1 || path_v1_N == -1 || path_v1_v2 == - 1 || path_v2_N == -1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dijkstra(int src, int dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.node;
            if (u == dest) {
                return dist[dest];
            }
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    protected static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{node=" + node + ", weight='" + weight + "'}";
        }
    }
}
