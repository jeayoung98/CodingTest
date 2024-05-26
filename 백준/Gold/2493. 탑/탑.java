import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

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
                writer.write("0 ");
            } else {
                if (i == num - 1) {
                    writer.write(map.get(stack.peek())+"");
                }else writer.write(map.get(stack.peek()) + " ");
            }
            stack.push(k);
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
