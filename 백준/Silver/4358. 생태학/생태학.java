import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        HashMap<String, Integer> map = new HashMap<>();
        int wordCount = 0;
        while ((line = br.readLine()) != null) {
            map.put(line, map.getOrDefault(line, 0) + 1);
            wordCount++;
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            DecimalFormat df = new DecimalFormat("#.####");
            float value = Float.parseFloat(df.format(map.get(key) / (float) wordCount * 100)) ;
            System.out.printf("%s %.4f\n",key,value);
        }
    }
}