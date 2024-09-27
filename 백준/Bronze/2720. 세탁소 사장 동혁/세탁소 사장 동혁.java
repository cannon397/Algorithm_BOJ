import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer[] = new int[4];
        for(int i = 0; i < T; i++){
            int C = Integer.parseInt(br.readLine());
            int remain = 0;
            answer[0] = C / 25;
            remain = C % 25;

            answer[1] = remain / 10;
            remain %= 10;

            answer[2] = remain / 5;
            remain %= 5;

            answer[3] = remain;
            System.out.printf("%d %d %d %d\n",answer[0],answer[1],answer[2],answer[3]);
        }
    }
}