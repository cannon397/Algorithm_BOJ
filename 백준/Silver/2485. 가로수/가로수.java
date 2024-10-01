import java.util.Scanner;


public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }
        int gcd = 0;
        int minLength = 0;
        for (int i = 1; i < N; i++) {
            minLength = tree[i] - tree[i - 1];
            gcd = gcd(gcd, minLength);
        }
        int answer = 0;
        for (int i = 1; i < N; i++) {
            answer += (tree[i] - tree[i - 1]) / gcd - 1;
        }

        System.out.println(answer);
    }
    static int gcd(int a, int b){
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return  a;
    }
}