import java.io.*;
import java.util.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] C = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if(A[i].equals("0")){
                deque.addFirst(Integer.parseInt(B[i]));
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            deque.addLast(Integer.parseInt(C[i]));
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}