import java.util.*;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long a = h1 * 3600L + m1 * 60L + s1;
        long b = h2 * 3600L + m2 * 60L + s2;
        
        long x = 59L * 719L;
        
        long start = a * x;
        long end = b * x;
        
        long min = 3600L * 719L;
        
        ArrayList<Long> list = new ArrayList<>();
        
        for (long k = 0; ; k++) {
            long t = k * min;
            if (t > end) break;
            if (t >= start) {
                list.add(t);
            }
        }
        long hour = 43200L * 59L;
        for (long m = 0; ; m++) {
            long t = m * hour;
            if (t > end) break;
            if (t >= start) {
                list.add(t);
            }
        }
        
        Collections.sort(list);
        int count = 0;
        long last = -1;
        for (long time : list) {
            if (count == 0 || time != last) {
                count++;
                last = time;
            }
        }
        
        return count;
    }
}
