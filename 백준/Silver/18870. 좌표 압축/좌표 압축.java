import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] temp = new int[N];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            temp[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(temp);
        int sequence = -1;
        int last = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            if (last == temp[i]) map.put(temp[i],sequence);
            else map.put(temp[i],++sequence);
            last = temp[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
