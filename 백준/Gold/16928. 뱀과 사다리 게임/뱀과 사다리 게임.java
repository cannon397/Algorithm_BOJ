import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static HashMap<Integer, Integer> ladder;
    static HashMap<Integer, Integer> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = condition[0];
        int M = condition[1];
        ladder = new HashMap<>();
        snake = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int[] ladderPosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ladder.put(ladderPosition[0], ladderPosition[1]);
        }
        for (int i = 0; i < M; i++) {
            int[] snakePosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            snake.put(snakePosition[0], snakePosition[1]);
        }
        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] answer = new int[101];
        Arrays.fill(answer, -1);
        answer[1] = 0;
        while (!q.isEmpty()) {
            int position = q.poll();
            if (position == 100) break;
            for (int i = 1; i <= 6; i++) {
                int nextPosition = position + i;
                if (nextPosition > 100) {
                    break;
                }
                if (snake.containsKey(nextPosition)) {
                    nextPosition = snake.get(nextPosition);
                } else if (ladder.containsKey(nextPosition)) {
                    nextPosition = ladder.get(nextPosition);
                }

                if(answer[nextPosition] == -1){
                    answer[nextPosition] = answer[position] + 1;
                    q.add(nextPosition);
                }
            }
        }
        System.out.println(answer[100]);
    }
}