import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Queue<Integer>> map = new HashMap<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("1")) {
                Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
                for (int j = 3; j < s.length; j++) {
                    queue.add(Integer.parseInt(s[j]));
                }
                Queue<Integer> current = map.getOrDefault(s[1], new PriorityQueue<>(Collections.reverseOrder()));
                current.addAll(queue);
                map.put(s[1], current);
            } else {
                Queue<Integer> current = map.getOrDefault(s[1], null);
                if (current != null){
                    if (current.size() <= Integer.parseInt(s[2])) {
                        while (!current.isEmpty()) {
                            result += current.poll();
                        }
                    } else {
                        for (int j = 0; j < Integer.parseInt(s[2]); j++) {
                            result += current.poll();
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
