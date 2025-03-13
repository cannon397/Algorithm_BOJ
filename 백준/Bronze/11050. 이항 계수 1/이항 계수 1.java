import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int answer = 1;
        int mod = 1;
        for (int i = 0; i < K; i++) {
            answer *= N - i;
        }
        for (int i = 0; i < K; i++) {
            mod *= K - i;
        }
        System.out.println(answer / mod);
    }
}