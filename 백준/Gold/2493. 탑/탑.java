import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(reader.readLine());

        String[] inputNumbers = reader.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            int k = Integer.parseInt(inputNumbers[i]);
            map.put(k, i + 1);

            while (!stack.empty() && stack.peek() < k) {
                stack.pop();
            }
            if (stack.empty()) {
                sb.append("0 ");
            } else {
                if (i == num - 1) {
                    sb.append(map.get(stack.peek()));
                }else sb.append(map.get(stack.peek())).append(" ");
            }
            stack.push(k);
        }
        System.out.println(sb);
    }
}