class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        long width1 = (long) r1 * r1;
        long width2 = (long) r2 * r2;
        
        for (int x = -r2; x <= r2; x++) {
            long width = (long) x * x;

            int min = (int) Math.ceil((width1 > width) ? Math.sqrt(width1 - width) : 0.0);
            int max = (int) Math.floor(Math.sqrt(width2 - width));

            if (min == 0) {
                count += 1 + 2L * (max - min);
            } else {
                count += 2L * (max - min + 1);
            }
        }
        
        return count;
    }
}