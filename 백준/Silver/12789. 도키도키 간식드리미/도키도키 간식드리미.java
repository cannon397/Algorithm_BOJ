import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] student = new int[N + 1];
        student[N] = N + 1;
        int[] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < temp.length; i++) {
            student[i] = temp[i];
        }

        int order = 1;
        int count = 0;
        while (count < student.length) {
            boolean flag = true;
            while(flag){
                if (!stack.isEmpty() && stack.peek() == order) {
                    order++;
                    stack.pop();
                } else {
                    flag = false;
                }
            }
            if (student[count] == order) {
                order++;
            } else {
                stack.push(student[count]);
            }
            count++;
        }
        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}