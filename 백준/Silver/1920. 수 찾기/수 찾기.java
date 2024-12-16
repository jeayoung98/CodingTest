import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] s = br.readLine().split(" ");
        Set<String> A = new HashSet<>(Arrays.asList(s));
        br.readLine();
        String[] s1 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            if (A.contains(s1[i])) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb.toString());

    }
}