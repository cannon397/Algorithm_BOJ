import java.util.Scanner;


public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if(M <= 2){
            sb.append(2).append("\n");
            M = 3;
        }
        for (int i = M; i <= N; i++) {
            double squareRoot = Math.sqrt(i);
            boolean flag = false;
            for (int j = 2; j <= squareRoot; j++) {
                if(i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}