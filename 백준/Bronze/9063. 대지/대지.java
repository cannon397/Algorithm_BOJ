import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 1) {
            System.out.println(0);
        } else {
            String line;
            int minX = 10000;
            int minY = 10000;
            int maxX = -10000;
            int maxY = -10000;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
            }
                System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}