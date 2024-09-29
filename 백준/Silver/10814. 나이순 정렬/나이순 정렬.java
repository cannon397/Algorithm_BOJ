import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] member = new String[N][2];
        for (int i = 0; i < N; i++) {
            member[i] = br.readLine().split(" ");
        }
        Arrays.sort(member, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));


        StringBuilder sb = new StringBuilder();
        for (String[] data : member) {
            String age = data[0];
            String name = data[1];
            sb.append(age).append(" ").append(name).append("\n");
        }
        System.out.println(sb);
    }
}