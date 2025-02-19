import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            int j = i;
            map1.computeIfAbsent(arr[i], a -> j);
        }

        Arrays.sort(arr, (a, b) -> {
            if (map.get(b) == map.get(a)) {
                return map1.get(a) - map1.get(b);
            }
            return map.get(b) - map.get(a);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
