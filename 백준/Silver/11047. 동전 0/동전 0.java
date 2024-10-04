import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> coinList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(coinList,Collections.reverseOrder());
        int answer = 0;
        for (int coin : coinList){
            int mod = K / coin;
            if(mod > 0){
                K -= mod * coin;
                answer += mod;
            }
        }
        System.out.println(answer);
    }
}