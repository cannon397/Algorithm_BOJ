import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] position1 = br.readLine().split(" ");
        String[] position2 = br.readLine().split(" ");
        String[] position3 = br.readLine().split(" ");
        String x;
        String y;
        if (position1[0].equals(position2[0])) {
            x = position3[0];
        } else if (position1[0].equals(position3[0])) {
            x = position2[0];
        } else {
            x = position1[0];
        }

        if (position1[1].equals(position2[1])) {
            y = position3[1];
        } else if (position1[1].equals(position3[1])) {
            y = position2[1];
        } else {
            y = position1[1];
        }
        System.out.printf("%s %s", x, y);
    }
}