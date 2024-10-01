import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                stack.pop();

            } else {
                stack.add(N);
            }
        }
        int answer = 0;
        for (Integer number: stack){
            answer += number;
        }
        System.out.println(answer);
    }
}