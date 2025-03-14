import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int number : numbers){
            sum += number;
            map.put(number, map.getOrDefault(number,0) + 1);
        }
        System.out.println(Math.round((float)sum / N));
        Arrays.sort(numbers);

        System.out.println(numbers[N / 2]);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            int freqCompare = Integer.compare(map.get(o2), map.get(o1));
            return freqCompare != 0 ? freqCompare : Integer.compare(o1, o2);
        });
        if( N != 1){
            if(map.get(list.get(0)).equals(map.get(list.get(1)))){
                System.out.println(list.get(1));
            }else {
                System.out.println(list.get(0));
            }
        }else{
            System.out.println(list.get(0));
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1) - list.get(0));

    }
}