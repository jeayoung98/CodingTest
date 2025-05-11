import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String originWord = br.readLine();
        int[] originArr = analyze(originWord);

        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            String compareWord = br.readLine();
            int[] compareArr = analyze(compareWord);

            int diff = 0;
            for (int j = 0; j < originArr.length; j++) {
                diff += Math.abs(originArr[j] - compareArr[j]);
            }

            if (diff <= 1 || (diff == 2 && originWord.length() == compareWord.length())) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static int[] analyze(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'A']++;
        }
        return arr;
    }
}