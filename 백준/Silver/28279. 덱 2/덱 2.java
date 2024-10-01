import java.io.*;
import java.util.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<String> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] condition = br.readLine().split(" ");
            switch (condition[0]) {
                case "1":
                    deque.addFirst(condition[1]);
                    break;
                case "2":
                    deque.addLast(condition[1]);
                    break;
                case "3":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case "4":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "7":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "8":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}