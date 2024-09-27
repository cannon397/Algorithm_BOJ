import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            int flag = 0;
            for (int j = 1; j <= numbers[i]; j++) {
                if(numbers[i] % j == 0) flag++;
            }
            if(flag == 2) answer++;
        }
        System.out.println(answer);
    }
}