import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] str = reader.readLine().split(" ");
        int[] i = Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .toArray();

        // 빈도 수 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : i) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        // 중복 값 제거
        int[] j = Arrays.stream(i).distinct().toArray();

        // 나온 순서
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int x = 0; x < j.length; x++) {
            map1.put(j[x], x);
        }

        List<Integer> list = Arrays.stream(i).boxed().sorted(
                (a, b) -> {
                    if (map.get(a) != map.get(b)) {
                        return map.get(b) - map.get(a);
                    } else return map1.get(a) - map1.get(b);
                }
        ).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int x : list) {
            sb.append(x+" ");
        }
        System.out.println(sb.toString().trim());
    }
}