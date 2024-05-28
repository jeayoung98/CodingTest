import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        long count = 0;
        for (int j = 0; j < i; j++) {
            int k = Integer.parseInt(reader.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek() <= k) {
                    stack.pop();
                }else break;
            }
            stack.push(k);
            count += stack.size()-1;
        }
        reader.close();
        System.out.println(count);
    }
}