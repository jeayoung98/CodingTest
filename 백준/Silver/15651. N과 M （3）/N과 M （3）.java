import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(n,m,list,sb);
        System.out.println(sb);
        sc.close();
    }

    public static void backTrack(int n, int m, List<Integer> list,StringBuilder sb) {
        if (list.size() == m) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            list.add(i);
            backTrack(n,m,list,sb);
            list.remove(list.size()-1);
        }
    }
}
