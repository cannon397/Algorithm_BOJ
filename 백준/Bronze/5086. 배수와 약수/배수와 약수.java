import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            String[] numbers = line.split(" ");
            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);
            
            if(A == B && A == 0){
                continue;
            }

            if(B % A == 0){
                System.out.println("factor");
                continue;
            }
            
            if(A % B == 0){
                System.out.println("multiple");
                continue;
            }
            
            System.out.println("neither");
            
        }
    }
}