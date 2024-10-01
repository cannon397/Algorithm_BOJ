import java.io.*;
import java.util.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int N = Integer.parseInt(condition[0]);
        int K = Integer.parseInt(condition[1]);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        int index = 1;
        StringBuilder sb = new StringBuilder().append("<");
        while(!q.isEmpty()){
            if(index != K){
                int temp = q.poll();
                q.add(temp);
                index++;
            }else{
                index=1;
                sb.append(q.poll());
                if(!q.isEmpty()){
                    sb.append(", ");
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}