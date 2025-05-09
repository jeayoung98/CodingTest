import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currentStr = "";
        while (true) {
            currentStr = br.readLine();
            if (currentStr.equals("end")) break;
            char[] c = currentStr.toCharArray();
            if (hasVowel(c) && threeInRow(c) && sameWord(c)) {
                System.out.printf("<%s> is acceptable.\n", currentStr);
            } else System.out.printf("<%s> is not acceptable.\n", currentStr);

        }
    }

    public static boolean sameWord(char[] c) {
        char lastC = c[0];
        for (int i = 1; i < c.length; i++) {
            if (lastC == c[i] && lastC != 'e' && lastC != 'o') {
                return false;
            }
            lastC = c[i];
        }
        return true;
    }

    public static boolean threeInRow(char[] c) {
        int countV = 0;
        int countC = 0;
        for (char c1 : c) {
            if (set.contains(c1)) {
                countV++;
                countC = 0;
            }else {
                countC++;
                countV = 0;
            }
            if (countV == 3 || countC == 3) return false;
        }
        return true;
    }

    public static boolean hasVowel(char[] c) {
        for (char c1 : c) {
            if (set.contains(c1)) {
                return true;
            }
        }
        return false;
    }
}
