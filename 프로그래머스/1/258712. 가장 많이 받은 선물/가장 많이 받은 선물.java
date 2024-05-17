import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        // 정보 저장할 맵
        Map<String, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], new int[friends.length]);
        }

        // 누가 누구에게 주었는지 저장
        for (String gift : gifts) {
            String[] str = gift.split(" ");
            String giver = str[0];
            String receiver = str[1];
            int[] arr = map.get(giver); // giver가 준 선물 리스트
            for (int j = 0; j < friends.length; j++) {
                if (receiver.equals(friends[j])) {
                    arr[j] += 1; // receiver에 해당하는 인덱스에 +1
                    break;
                }
            }
        }

        // 각 친구가 준 선물과 받은 선물의 합계
        int[] send = new int[friends.length];
        int[] receive = new int[friends.length];
        int cnt1 = 0;

        for (String friend : map.keySet()) {
            int[] sendGifts = map.get(friend);
            int sendSum = 0;
            for (int i = 0; i < sendGifts.length; i++) {
                sendSum += sendGifts[i];
                if (sendGifts[i] != 0) {
                    receive[i] += sendGifts[i]; // 각 친구가 받은 선물의 수를 계산
                }
            }
            send[cnt1] = sendSum;
            cnt1++;
        }

        // 선물 지수
        int[] result = new int[friends.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = send[i] - receive[i];
        }

        //받은 선물 정보
        int[][] arr2 = new int[friends.length][friends.length];
        int idx = 0;
        for (String friend : map.keySet()) {
            arr2[idx] = map.get(friend);
            idx++;
        }

        // 선물 받을사람
        int[] nextGifts = new int[friends.length];
        // 전치행렬과 비교
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i; j < arr2[i].length; j++) {
                if (arr2[i][j] > arr2[j][i]) nextGifts[i]++; 
                if (arr2[i][j] < arr2[j][i]) nextGifts[j]++;
                if (i != j && (arr2[i][j] == arr2[j][i])) {
                    if (result[i] < result[j]) {
                        nextGifts[j]++;
                    } else if (result[i] > result[j]) {
                        nextGifts[i]++;
                    }
                }
            }
        }

        // 가장 많이 받을 사람
        int max1 = 0;
        for (int num : nextGifts) {
            max1 = Math.max(num, max1);
        }
        answer = max1;
        return answer;
    }
}
