import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, Integer> times = new TreeMap<>(); 
        Map<String, String> in = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0], carNumber = parts[1], action = parts[2];
            if (action.equals("IN")) {
                in.put(carNumber, time);
            } else {
                times.merge(carNumber, getTime(in.remove(carNumber), time), Integer::sum);
            }
        }
        in.forEach((car, inTime) -> times.merge(car, getTime(inTime, "23:59"), Integer::sum));

        return times.values().stream()
                    .mapToInt(time -> calculate(time, defaultTime, defaultFee, unitTime, unitFee))
                    .toArray();
    }

    private int getTime(String start, String end) {
        return convert(end) - convert(start);
    }

    private int convert(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }

    private int calculate(int totalTime, int defaultTime, int defaultFee, int unitTime, int unitFee) {
        if (totalTime <= defaultTime) {
            return defaultFee;
        }
        int overTime = (totalTime - defaultTime + unitTime - 1) / unitTime;
        return defaultFee + overTime * unitFee;
    }
}
