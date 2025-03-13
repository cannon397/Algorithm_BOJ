import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int a1;
    static int a0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fn = br.readLine().split(" ");
        a1 = Integer.parseInt(fn[0]);
        a0 = Integer.parseInt(fn[1]);
        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        System.out.println(((a1 * n + a0) <= (n * c) && (c >= a1))? 1 : 0);
    }
}