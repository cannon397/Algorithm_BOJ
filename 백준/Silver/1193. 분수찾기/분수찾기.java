import java.io.*;
public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int layer = 1;
        int result = 1;
        if (X == 1) {
            System.out.println("1/1");
        } else {
            while (result < X) {
                layer++;
                result += layer;

            }
            if (layer % 2 == 0) {
                System.out.printf("%d/%d", (layer - (result - X)), (result - X + 1));
            } else {
                System.out.printf("%d/%d", (result - X + 1), (layer - (result - X)));
            }
            System.out.println();
        }

    }
}