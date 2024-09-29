import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] position = new int[N][2];
        for (int i = 0; i < N; i++) {
            position[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        Arrays.sort(position, (o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                }

        );
        StringBuilder sb = new StringBuilder();
        for (int[] coordinate : position) {
            int x = coordinate[0];
            int y = coordinate[1];
            sb.append(String.format("%d %d\n", x, y));
        }
        System.out.println(sb);
    }
}