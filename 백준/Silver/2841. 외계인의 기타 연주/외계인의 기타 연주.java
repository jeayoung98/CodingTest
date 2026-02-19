import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i <= 6; i++) stack[i] = new Stack<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            Stack<Integer> s = stack[line];

            while (!s.isEmpty() && s.peek() > fret) {
                s.pop();
                count++;
            }

            if (!s.isEmpty() && s.peek() == fret) continue;

            s.push(fret);
            count++;
        }

        System.out.println(count);
    }
}
