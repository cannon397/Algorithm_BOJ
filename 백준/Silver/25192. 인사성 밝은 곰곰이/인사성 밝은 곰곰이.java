import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chatLogCount = Integer.parseInt(br.readLine());
        String line;
        Set<String> set = new HashSet<>();
        int answer = 0;
        while ((line = br.readLine()) != null) {
//            1. 엔터를 확인한 뒤 첫 채팅은 무조건 이모티콘이다
            if (line.equals("ENTER")) {
                answer += set.size();
                set = new HashSet<>();
            } else {
                set.add(line);
            }
        }
        answer += set.size();
        System.out.println(answer);
    }
}
