import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            String[] times = br.readLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, (a, b) -> {
            if (a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        int count = 0;
        int currentEndTime = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= currentEndTime) {
                currentEndTime = meeting.end;
                count++;
            }
        }

        System.out.println(count);
    }
}
