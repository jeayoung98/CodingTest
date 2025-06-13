import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Condition {
        String name;
        int num;

        public Condition(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Condition> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a[0]; i++) {
            String[] s = br.readLine().split(" ");
            Condition condition = new Condition(s[0], Integer.parseInt(s[1]));
            if (!set.contains(Integer.parseInt(s[1]))) {
                list.add(condition);
                set.add(Integer.parseInt(s[1]));
            }
        }
        list.sort((x, y) -> x.num - y.num);
        int n = list.size();
        int[] num = new int[n];
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            num[i] = list.get(i).num;
            name[i]  = list.get(i).name;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a[1]; i++) {
            int cur = Integer.parseInt(br.readLine());

            int index = Arrays.binarySearch(num, cur);
            if (index < 0) index = -index - 1;
            if (index == n) index = n - 1;

            sb.append(name[index]).append('\n');
        }
        System.out.print(sb);
    }
}
