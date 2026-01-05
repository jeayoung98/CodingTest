import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long goal = Long.parseLong(br.readLine());

        int nx = (int) ((x + goal) % (2L * col));
        int ny = (int) ((y + goal) % (2L * row));

        x = (nx <= col) ? nx : (2 * col - nx);
        y = (ny <= row) ? ny : (2 * row - ny);

        System.out.println(x + " " + y);
    }
}
