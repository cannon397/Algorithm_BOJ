import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        if (A == 60 && B == 60 && C == 60) {
            System.out.println("Equilateral");
        } else if (A + B + C == 180) {
            if (A == B || A == C || B == C) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else if (A + B + C != 180) {
            System.out.println("Error");
        }
    }
}