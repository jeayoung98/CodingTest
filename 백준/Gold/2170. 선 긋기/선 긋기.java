import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line {
        private int start;
        private int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new Line(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        list.sort((a,b)->{
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });
        long result = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (Line line : list) {
            if (line.start > lastEnd) {
                result += line.end - line.start;
                lastEnd = line.end;
            } else if (line.end > lastEnd) {
                result += line.end - lastEnd;
                lastEnd = line.end;
            }
        }
        System.out.println(result);
    }
}
