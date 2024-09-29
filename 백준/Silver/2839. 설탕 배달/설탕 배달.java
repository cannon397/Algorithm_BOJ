import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int temp = N;
        int M = N / 3;
        int answer = -1;
        for (int i = M; i >= 0; i--) {
            int sugar = temp - i * 3;
            if(sugar == 0){
                answer = i;
            }
            if(sugar != 0 && sugar % 5 == 0){
                answer = (sugar / 5) + i;
            }
        }
        System.out.println(answer);
    }
}