import java.io.*;
import java.util.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Deque<Balloon> deque = new ArrayDeque<>();
        for (int index = 0; index < input.length; index++) {
            int number = Integer.parseInt(input[index]);
            Balloon balloon = new Balloon(index + 1,number);
            deque.add(balloon); // Deque에 추가
        }
        StringBuilder sb = new StringBuilder();


        while (!deque.isEmpty()) {
            Balloon balloon = deque.poll();
            int movePoint = balloon.movePoint;
            if (movePoint > 0) {
                for (int i = 1; i < movePoint; i++) {
                    if (!deque.isEmpty()) {
                        Balloon temp = deque.pollFirst();
                        deque.addLast(temp);
                    }
                }
            } else {
                for (int i = 0; i < Math.abs(movePoint); i++) {
                    if (!deque.isEmpty()) {
                        Balloon temp = deque.pollLast();
                        deque.addFirst(temp);
                    }
                }
            }
            sb.append(balloon.index).append(" ");
        }
        System.out.println(sb);
    }

    static class Balloon {
        int index;
        int movePoint;

        public Balloon(int index, int movePoint) {
            this.index = index;
            this.movePoint = movePoint;
        }
    }
}