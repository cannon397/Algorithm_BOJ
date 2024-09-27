import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            if (n == -1) break;

            int yaksuHap = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    yaksuHap += i;
                    sb.append(i + " ");
                }
            }
            if (yaksuHap == n) {
                bw.write(String.format("%d = ",n));
                String[] numbers = sb.toString().split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    bw.write(numbers[i]);
                    if(numbers.length - 1 != i) bw.write(" + ");
                }
                bw.newLine();
            } else {
                bw.write(String.format("%d is NOT perfect.",n));
                bw.newLine();
            }
        }
        bw.flush();
    }
}