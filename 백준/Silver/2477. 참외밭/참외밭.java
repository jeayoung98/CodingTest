import java.io.*;
import java.util.*;

public class Main {
    static class node{
        int dir;
        int len;
        public node(int dir, int len) {
            this.dir = dir;
            this.len = len;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        node[] arr = new node[6];
        int maxWidth = 0;
        int maxHeight = 0;
        int widthIdx = -1;
        int heightIdx = -1;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr[i] = new node(dir, len);
            if (dir == 3 || dir == 4) {
                maxHeight = Math.max(maxHeight, len);
                if (maxHeight == len) heightIdx = i;
            }

            if (dir == 1 || dir == 2) {
                maxWidth = Math.max(maxWidth, len);
                if (maxWidth == len) widthIdx = i;
            }
        }

        System.out.println((maxHeight * maxWidth - arr[(heightIdx + 3) % 6].len * arr[(widthIdx + 3) % 6].len) * N);


    }
}
