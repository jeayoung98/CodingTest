import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        Map<String, Integer> wordMap = new HashMap<>();
        List<String> blurList = new ArrayList<>();

        Set<Integer> blurrSet = new HashSet<>();

        char[] arr = message.toCharArray();

        List<int[]> wordRanges = new ArrayList<>();
        List<String> words = new ArrayList<>();

        int start = 0;

        for (int i = 0; i <= arr.length; i++) {

            if (i == arr.length || arr[i] == ' ') {

                if (start < i) {
                    String word = message.substring(start, i);
                    words.add(word);
                    wordRanges.add(new int[]{start, i - 1});
                    wordMap.put(word,wordMap.getOrDefault(word, 0) + 1);
                }

                start = i + 1;
            }
        }

        for (int[] spo : spoiler_ranges) {

            int ss = spo[0];
            int se = spo[1];

            for (int i = 0; i < wordRanges.size(); i++) {
                int ws = wordRanges.get(i)[0];
                int we = wordRanges.get(i)[1];

                if (ws <= se && ss <= we) {

                    if (blurrSet.add(ws)) {
                        blurList.add(words.get(i));
                    }
                }
            }
        }

        for (String word : blurList) {
            wordMap.put(word,wordMap.get(word) - 1);
        }

        for (String word : blurList) {
            if (wordMap.get(word) == 0) {
                answer++;
            }

            wordMap.put(word,wordMap.get(word) + 1);
        }

        return answer;
    }
}