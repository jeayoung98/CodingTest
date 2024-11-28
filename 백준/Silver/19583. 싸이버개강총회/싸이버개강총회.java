import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = parseTime(s[0]);
        int M = parseTime(s[1]);
        int K = parseTime(s[2]);

        Map<String, Boolean> map = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            String[] parts = line.split(" ");
            if (parts.length < 2) continue; // 잘못된 입력 방지
            String name = parts[1];
            int time = parseTime(parts[0]);
            if (time <= N) {
                map.put(name, false);
            } else if (time >= M && time <= K && map.containsKey(name) && !map.get(name)) {
                map.put(name, true);
            }
        }
        br.close();

        int result = 0;
        for (String name : map.keySet()) {
            if (Boolean.TRUE.equals(map.get(name))) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static int parseTime(String timeStr) {
        String[] times = timeStr.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
