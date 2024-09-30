import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int rank = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] answer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] X = Arrays.copyOf(answer,answer.length);
        Arrays.sort(X);
        for (int number : X) {
            if (!hashMap.containsKey(number)) {
                hashMap.put(number, rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(hashMap.get(x)).append(" ");
        }
        System.out.println(sb);
    }
}