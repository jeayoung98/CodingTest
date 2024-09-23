import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 분으로 변경
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 시작 시간 기준 정렬
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));  

        for (String[] time : book_time) {
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1]) + 10;
            if (!queue.isEmpty() && queue.peek() <= start) {
                queue.poll();
            }
            queue.add(end);
        }
        return queue.size();
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}