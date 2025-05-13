import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String func = br.readLine();
            int index = shortCut(func.toLowerCase());
            for (int j = 0; j < func.length(); j++) {
                if (j == index) {
                    sb.append("[").append(func.charAt(j)).append("]");
                } else sb.append(func.charAt(j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int shortCut(String func) {
        String[] s = func.split(" ");
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            String[] s1 = s[i].split("");
            if (!set.contains(s1[0])) {
                set.add(s1[0].toLowerCase());
                return count;
            }
            count += s[i].length() + 1; // 1은 공백추가
        }
        String[] s1 = func.split("");
        for (int i = 0; i < func.length(); i++) {
            if (!set.contains(s1[i]) && !s1[i].equals(" ")) {
                set.add(s1[i]);
                return i;
            }
        }
        return -1;
    }
}
