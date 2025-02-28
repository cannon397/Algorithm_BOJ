import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int N;
    static int M;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mapSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = mapSize[0];
        M = mapSize[1];
        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] position = q.poll();
            int cX = position[0];
            int cY = position[1];
            int answer = position[2];
            int wall = position[3];
            if (cX == N - 1 && cY == M - 1) {
                System.out.println(answer);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;

//                System.out.printf("CurrentPosition: (%d,%d) nextPosition: (%d, %d) wall: %d%n", cX, cY, nX, nY, wall);
                if (map[nX][nY] == 0) { // 벽이 아니면
                    if (wall == 0 && !visited[0][nX][nY]) { //부신 벽이 여태 없으면
                        visited[0][nX][nY] = true;
                        q.add(new int[]{nX, nY, answer + 1, 0});
                    } else if (wall == 1 && !visited[1][nX][nY]) { //벽을 부신적이 있으면
                        visited[1][nX][nY] = true;
                        q.add(new int[]{nX, nY, answer + 1, 1});
                    }

                } else if (map[nX][nY] == 1) {
                    if (wall == 0) {
                        q.add(new int[]{nX, nY, answer + 1, 1});
                        visited[1][nX][nY] = true;
                    }
                }

            }
        }
        System.out.println(-1);
    }
}