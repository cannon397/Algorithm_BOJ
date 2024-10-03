import java.io.*;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] A;
    static int max = -1000000000;
    static int min = 1000000000;
    /**
     * 0 => +
     * 1 => -
     * 2 => x
     * 3 => /
     */
    static int[] operator; //

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operator = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dfs(0, 0);
        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int depth, int value) {
        if (N == depth) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        if(depth != 0) {
            for (int j = 0; j < operator.length; j++) {
                if (operator[j] > 0) {
                    operator[j]--;
                    switch (j) {
                        case 0:
                            value += A[depth];
                            dfs(depth + 1, value);
                            value -= A[depth];
                            break;
                        case 1:
                            value -= A[depth];
                            dfs(depth + 1, value);
                            value += A[depth];
                            break;
                        case 2:
                            value *= A[depth];
                            dfs(depth + 1, value);
                            value /= A[depth];
                            break;
                        case 3:
                            value /= A[depth];
                            dfs(depth + 1, value);
                            value *= A[depth];
                            break;
                    }
                    operator[j]++;
                }
            }
        }else{
            dfs(depth + 1, A[depth]);
        }
    }
}