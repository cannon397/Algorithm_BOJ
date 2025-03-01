import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] oilPrice = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (int i = 1; i < oilPrice.length - 1; i++) {
            if(oilPrice[i - 1] < oilPrice[i]){
                oilPrice[i] = oilPrice[i-1];
            }
        }
        long answer = 0;
        for (int i = 0; i < distances.length; i++) {
            answer += distances[i] * oilPrice[i];
        }
        System.out.println(answer);
    }
}