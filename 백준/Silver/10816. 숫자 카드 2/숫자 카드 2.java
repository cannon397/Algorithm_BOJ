import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(br.readLine());
        int[] checks = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int card : cards) {
            hashMap.put(card,hashMap.getOrDefault(card,0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int check : checks){
            sb.append(hashMap.getOrDefault(check,0)).append(" ");
        }
        System.out.println(sb);
    }
}