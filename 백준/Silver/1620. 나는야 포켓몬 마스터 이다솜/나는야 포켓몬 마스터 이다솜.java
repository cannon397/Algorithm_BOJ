import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] condition = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = condition[0];
        int M = condition[1];
        HashMap<String,String> hashMap1 = new HashMap<>();
        HashMap<String,String> hashMap2 = new HashMap<>();
        int index = 1;
        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            hashMap1.put(pokemon,String.valueOf(index));
            hashMap2.put(String.valueOf(index++),pokemon);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            if(hashMap1.containsKey(problem)){
                sb.append(hashMap1.get(problem)).append("\n");
            } else {
                sb.append(hashMap2.get(problem)).append("\n");
            }
        }
        System.out.println(sb);
    }
}