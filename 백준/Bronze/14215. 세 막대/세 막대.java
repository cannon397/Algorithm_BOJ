import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] numbers = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int A = numbers[0];
            int B = numbers[1];
            int C = numbers[2];
            int max = Math.max(Math.max(A, B), C);
            int ABC = A + B + C;

            while( max >= ABC - max ){
                   ABC--;
                   max--;
            }
            System.out.println(ABC);
        }
    }
}