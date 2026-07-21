class Solution {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String b = Long.toBinaryString(numbers[i]);
            String pb = padding(b);

            answer[i] = check(pb, 0, pb.length() - 1, '1')? 1 : 0;
        }

        return answer;
    }

    public String padding(String b) {
        int size = 1;

        while (size < b.length()) {
            size = size * 2 + 1;
        }

        int zero = size - b.length();

        return "0".repeat(zero) + b;
    }

    // 부모 노드 0 확인
    public boolean check(String b, int left, int right, char parent){
        if (left > right) {
            return true;
        }

        int mid = (left + right) / 2;
        char current = b.charAt(mid);

        if (parent == '0' && current == '1') {
            return false;
        }

        boolean valid = check(b, left, mid - 1, current);

        if (!valid) return false;

        return check(b, mid + 1, right, current);
    }
}