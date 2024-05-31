import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {
            str = reader.readLine();
            if (str.equals(".")) {
                break;
            }

            if (isBalanced(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if ((ch == ')' && open != '(') || (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}