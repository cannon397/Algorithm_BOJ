import java.util.Scanner;


public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int M = 0;
        StringBuilder sb = new StringBuilder();
        while ((M = sc.nextInt()) != 0){
            int N = 2 * M;
            int answer = 0;
            if (M <= 2) {
                answer++;
                M = 3;
            }
            for (int i = M + 1; i <= N; i++) {
                double squareRoot = Math.sqrt(i);
                boolean flag = false;
                for (int j = 2; j <= squareRoot; j++) {
                    if (i % j == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}