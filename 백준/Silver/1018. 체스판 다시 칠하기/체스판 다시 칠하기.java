import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = numbers[0];
        int M = numbers[1];

        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }
        int answer = 64;



        for (int i = 0; i <= board.length - 8; i++) {
            for (int j = 0; j <= board[i].length - 8; j++) {
                String one = "W";
                String two = "B";
                int count1 = 0;
                int count2 = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (!board[k][l].equals(one)) {
                            count1++;
                        }
                        if (!board[k][l].equals(two)) {
                            count2++;
                        }
                        one = one.equals("W") ? "B" : "W";
                        two = two.equals("B") ? "W" : "B";
                    }
                    one = one.equals("W") ? "B" : "W";
                    two = two.equals("B") ? "W" : "B";
                }
                answer = Math.min(answer,Math.min(count2,count1));
            }
        }
        System.out.println(answer);
    }
}