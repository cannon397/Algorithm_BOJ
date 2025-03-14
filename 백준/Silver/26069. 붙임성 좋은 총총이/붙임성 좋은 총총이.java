import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line;
        Set<String> set = new HashSet<>();
        while((line = br.readLine()) != null){
            String[] people = line.split(" ");
            String from = people[0];
            String to = people[1];
            if(from.equals("ChongChong") || to.equals("ChongChong")){
                set.add(from);
                set.add(to);
            }else if(set.contains(from) || set.contains(to)){
                set.add(from);
                set.add(to);
            }
        }
        System.out.println(set.size());
    }
}