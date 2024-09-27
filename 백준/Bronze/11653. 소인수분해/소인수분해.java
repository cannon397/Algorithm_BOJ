import java.io.*;
import java.util.stream.*;

public class Main {
    static int condition;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        condition = N;
        soinsu(N, 2);

    }
    static int soinsu(int N, int num){
        if (N == 1) return -1;
        if(condition == num) {
            System.out.println(condition);
            return -1;
        }
        int share = N / num;
        int remain = N % num;
        if(remain > 0) return soinsu(N, num + 1);
        else {
            System.out.println(num);
            return soinsu(share, num);
        }
    }
}