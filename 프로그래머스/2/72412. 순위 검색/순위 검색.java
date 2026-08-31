import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        String[][] conditions = {
                {"java", "cpp", "python", "-"},
                {"backend", "frontend", "-"},
                {"junior", "senior", "-"},
                {"pizza", "chicken", "-"}
        };

        // 1. 가능한 모든 조건 Map 생성
        for (String lang : conditions[0]) {
            for (String pos : conditions[1]) {
                for (String career : conditions[2]) {
                    for (String food : conditions[3]) {

                        String key = lang + " " + pos + " " + career + " " + food;
                        map.put(key, new ArrayList<>());
                    }
                }
            }
        }

        // 2. info 등록
        for (String s : info) {
            String[] arr = s.split(" ");

            String[] values = {
                    arr[0],
                    arr[1],
                    arr[2],
                    arr[3]
            };

            int score = Integer.parseInt(arr[4]);

            for (int mask = 0; mask < 16; mask++) {

                StringBuilder key = new StringBuilder();

                for (int i = 0; i < 4; i++) {

                    if ((mask & (1 << i)) != 0) {
                        key.append("-");
                    } else {
                        key.append(values[i]);
                    }

                    if (i != 3) {
                        key.append(" ");
                    }
                }

                map.get(key.toString()).add(score);
            }
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");

            String key =arr[0] + " " +arr[1] + " " +arr[2] + " " +arr[3];

            int target = Integer.parseInt(arr[4]);

            List<Integer> scores = map.get(key);

            int idx = lowerBound(scores, target);

            answer[i] = scores.size() - idx;
        }

        return answer;
    }

    int lowerBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}