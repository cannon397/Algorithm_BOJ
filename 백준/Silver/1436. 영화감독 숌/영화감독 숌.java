import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = 0;

        int answer = 665;
        while(N != number){
            answer++;
               if(String.valueOf(answer).contains("666")){
                   number++;
               }
        }
        System.out.println(answer);
    }
}