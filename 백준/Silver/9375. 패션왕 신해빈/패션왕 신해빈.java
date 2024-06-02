import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String item = sc.next();
                String type = sc.next();

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }
            
            result -= 1;
            System.out.println(result);
        }
        sc.close();
    }
}