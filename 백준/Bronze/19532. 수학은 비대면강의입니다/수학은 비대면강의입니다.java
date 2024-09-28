import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];
        int d = numbers[3];
        int e = numbers[4];
        int f = numbers[5];
        
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (a * i + b * j == c) {
                    if (d * i + e * j == f) {
                        System.out.printf("%d %d", i, j);
                        return;
                    }
                }
            }
        }
    }
}