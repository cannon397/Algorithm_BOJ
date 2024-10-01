import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        boolean flag = true;
        int answer = 1;
        while(!q.isEmpty()){
            if(flag){
                q.poll();
                flag = false;
            }else{
                answer = q.poll();
                q.addLast(answer);
                flag = true;
            }
        }
        System.out.println(answer);
    }
}