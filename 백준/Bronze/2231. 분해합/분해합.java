import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = N; i > 0; i--) {
            String number = String.valueOf(i);
            int divide = Arrays.stream(number.split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();
            if(!number.contains("0") && i + divide == N){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}