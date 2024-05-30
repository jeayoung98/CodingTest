import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int dic = Integer.parseInt(str[0]);
        int question = Integer.parseInt(str[1]);

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map1 = new HashMap<>();

        for (int i = 0; i < dic; i++) {
            String name = reader.readLine();
            map1.put(i + 1, name);
            map.put(name, i + 1);
        }

        for (int i = 0; i < question; i++) {
            String question1 = reader.readLine();
            try {
                int num = Integer.parseInt(question1);
                System.out.println(map1.get(num));
            } catch (NumberFormatException e) {
                System.out.println(map.get(question1));
            }
        }
        reader.close();
    }
}