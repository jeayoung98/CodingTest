import java.util.*;

class Solution {
    static class FileInfo {
        String original;
        String head;
        int number;

        FileInfo(String original, String head, int number) {
            this.original = original;
            this.head = head;
            this.number = number;
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        FileInfo[] arr = new FileInfo[files.length];

        for (int i = 0; i < files.length; i++) {
            arr[i] = parse(files[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            int headCompare = a.head.compareToIgnoreCase(b.head);

            if (headCompare != 0) {
                return headCompare;
            }

            return Integer.compare(a.number, b.number);
        });

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i].original;
        }

        return answer;
    }

    private FileInfo parse(String file) {
        int start = 0;

        while (start < file.length() && !Character.isDigit(file.charAt(start))) {
            start++;
        }

        int end = start;

        while (end < file.length() && Character.isDigit(file.charAt(end)) && end - start < 5) {
            end++;
        }

        String head = file.substring(0, start);
        int number = Integer.parseInt(file.substring(start, end));

        return new FileInfo(file, head, number);
    }
}