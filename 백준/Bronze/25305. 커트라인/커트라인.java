import java.util.*;
import java.io.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int N = Integer.parseInt(condition[0]);
        int k = Integer.parseInt(condition[1]);
        int[] score = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(score);
        System.out.println(score[score.length - k]);
    }
}