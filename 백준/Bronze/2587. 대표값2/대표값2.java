import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        int average = Arrays.stream(numbers).sum() / 5;
        Arrays.sort(numbers);
        int median = numbers[2];
        System.out.println(average);
        System.out.println(median);
    }
}