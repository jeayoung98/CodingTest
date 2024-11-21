import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, r, c;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        int size = (int) Math.pow(2, N);

        visit(0, 0, size);

        System.out.println(result);
    }

    public static void visit(int x, int y, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 2;

        if (r < x + newSize && c < y + newSize) {
            visit(x, y, newSize);
        } else if (r < x + newSize && c >= y + newSize) {
            result += newSize * newSize;
            visit(x, y + newSize, newSize);
        } else if (r >= x + newSize && c < y + newSize) {
            result += 2 * newSize * newSize;
            visit(x + newSize, y, newSize);
        } else {
            result += 3 * newSize * newSize;
            visit(x + newSize, y + newSize, newSize);
        }
    }
}
