import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int sum = Arrays.stream(s).mapToInt(Integer::parseInt).sum();
        Set<String> set = new HashSet<>();
        Set<String> result = new TreeSet<>();
        for (int i = 0; i < sum; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                result.add(name);
            } else set.add(name);
        }
        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}
