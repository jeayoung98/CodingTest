import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int countR = 0, countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') countR++;
            else countB++;
        }

        int leftR = 0;
        while (leftR < N && s.charAt(leftR) == 'R') leftR++;
        int leftB = 0;
        while (leftB < N && s.charAt(leftB) == 'B') leftB++;

        int rightR = 0;
        while (rightR < N && s.charAt(N - 1 - rightR) == 'R') rightR++;
        int rightB = 0;
        while (rightB < N && s.charAt(N - 1 - rightB) == 'B') rightB++;

        int result = Math.min(
                Math.min(countR - leftR, countR - rightR),
                Math.min(countB - leftB, countB - rightB)
        );

        System.out.println(result);
    }
}
