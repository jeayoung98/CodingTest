import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int M = Integer.parseInt(br.readLine());
            int result = 0;
            int speed = 0;
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if (a != 0) {
                    int b = Integer.parseInt(st.nextToken());
                    switch (a) {
                        case 1 : speed += b;
                            break;
                        case 2: speed -= b;
                            break;
                    }
                    if (speed <= 0) speed = 0;
                }

                result += speed;
            }

            sb.append("#").append(i).append(" ").append(result).append("\n");

        }
        System.out.println(sb);
    }
}
