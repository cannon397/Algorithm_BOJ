import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    static int answer;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int boardLength = Integer.parseInt(br.readLine());
            visited = new boolean[boardLength][boardLength];
            answer = Integer.MAX_VALUE;

            int[] night = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] destination = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            bfs(night[0], night[1], destination[0], destination[1], 0);
            System.out.println(answer);
        }
    }

    static void bfs(int row, int col, int destRow, int destCol, int count) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col, count});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] night = q.poll();
            int x = night[0];
            int y = night[1];
            int c = night[2];
            if(x == destRow && y == destCol){
                answer = c;
                return;
            }
            // 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int newRow = x + dx[i];
                int newCol = y + dy[i];

                if (newRow >= 0 && newCol >= 0 && newRow < visited.length && newCol < visited.length) {
                    if (!visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        q.add(new int[]{newRow,newCol,c+1});
                    }
                }
            }
        }
    }
}