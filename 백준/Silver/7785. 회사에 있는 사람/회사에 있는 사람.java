import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,String> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] logs = br.readLine().split(" ");
            hashMap.put(logs[0],logs[1]);
        }
        ArrayList<String> answer =new ArrayList<>();
        hashMap.forEach((k,v) -> {
            if(v.equals("enter")){
                answer.add(k);
            }
        });
        answer.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String person : answer){
            sb.append(person).append("\n");
        }
        System.out.println(sb);
    }
}