import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int min = 10000;
        for (int i = M; i <= N; i++) {
            int flag = 0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0) flag++;
            }
            if(flag == 2) {
                answer += i;
                min = Math.min(min,i);
            }
        }
        if(answer == 0) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
            System.out.println(min);
        }
    }
}