import java.util.*;
import java.io.*;


public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] condition = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int countA = condition[0];
        int countB = condition[1];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();


        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int number : A){
            setA.add(number);
        }

        for(int number : B){
            setB.add(number);
        }
        int answer = 0;
        for(int number : A){
            if(!setB.contains(number)){
                answer++;
            }
        }
        for(int number : B){
            if(!setA.contains(number)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}