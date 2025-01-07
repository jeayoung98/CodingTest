import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[M];
        String[] s1 = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < M; i++) {
            map.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);
        }

        Set<Integer> set = new HashSet<>();
        int result = 0;

        for(int i = 0; i < M; i++) {
            int current = arr[i];
            map.get(current).poll();

            if(set.contains(current)) {
                continue;
            }

            if(set.size() < N) {
                set.add(current);
            }
            else {
                int remove = -1;
                int last = -1;
                for(int x : set) {
                    Queue<Integer> queue = map.get(x);
                    if(queue.isEmpty()) {
                        remove = x;
                        break;
                    }
                    else {
                        int next = queue.peek();
                        if(next > last) {
                            last = next;
                            remove = x;
                        }
                    }
                }
                
                set.remove(remove);
                set.add(current);
                result++;
            }
        }

        System.out.println(result);
    }
}
