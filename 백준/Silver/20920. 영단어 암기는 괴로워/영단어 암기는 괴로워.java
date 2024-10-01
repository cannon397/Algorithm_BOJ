import java.io.*;
import java.util.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int N = Integer.parseInt(condition[0]);
        int M = Integer.parseInt(condition[1]);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
                    if (map.get(o2).compareTo(map.get(o1)) == 0) {
                        if (o1.length() == o2.length()) {
                            return o1.compareTo(o2);
                        } else {
                            return o2.length() - o1.length();
                        }
                    }
                    return map.get(o2).compareTo(map.get(o1));
                }
        );
        StringBuilder sb = new StringBuilder();
        for (String word: keySet){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}