import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < wires.length; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
       // 모든 간선에 대해 반복
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            // 간선 끊기 (양방향)
            graph.get(a).remove((Integer) b);
            graph.get(b).remove((Integer) a);

            // 한 쪽 컴포넌트의 크기 구하기 (BFS)
            int cnt = bfs(1, n, graph);

            // 차이 계산
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);

            // 간선 복구
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return answer;
    }

    // BFS로 컴포넌트 크기 세기
    private int bfs(int start, int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}