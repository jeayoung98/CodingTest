import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split("-");
        int result = 0;
        String[] s3 = s1[0].split("\\+");
        for (int i = 0; i < s3.length; i++) {
            result += Integer.parseInt(s3[i]);
        }
        for (int i = 1; i < s1.length; i++) {
            String current = s1[i];
            String[] s2 = current.split("\\+");
            int sum = 0;
            for (int j = 0; j < s2.length; j++) {
                sum += Integer.parseInt(s2[j]);
            }
            result -= sum;
        }
        System.out.println(result);
    }
}
