import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Stack<String> stack = new Stack<>();
        int goodWords = 0;
        for (int i = 0; i < count; i++) {
            String[] str = reader.readLine().split("");
            for (String s : str) {
                if (!stack.isEmpty() && stack.peek().equals(s)) {
                    stack.pop();
                }else stack.push(s);
            }
            if(stack.isEmpty()) goodWords++;
            stack.clear();
        }
        System.out.println(goodWords);
    }
}