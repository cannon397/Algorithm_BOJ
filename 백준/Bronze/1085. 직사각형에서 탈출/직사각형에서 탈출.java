import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = numbers[0];
        int y = numbers[1];
        int w = numbers[2];
        int h = numbers[3];
        int answer = Math.min(Math.abs(x - w), Math.abs(y - h));
        if(answer > x || answer > y) {
            answer = Math.min(x,y);
        }
        System.out.println(answer);
    }
}