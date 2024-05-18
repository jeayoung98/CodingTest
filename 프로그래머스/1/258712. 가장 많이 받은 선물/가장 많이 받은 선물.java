import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, int[]> giftMap = giftMap(friends, gifts);
        int[] send = sentGifts(giftMap, friends);
        int[] receive = receivedGifts(giftMap, friends);
        
        int[] result = giftScore(send, receive);
        int[][] giftMatrix = giftMatrix(giftMap, friends);
        
        int[] nextGifts = nextGifts(giftMatrix, result, friends);
        return findMax(nextGifts);
    }
    
    // 정보 저장할 맵
    public Map<String, int[]> giftMap(String[] friends, String[] gifts) {
        Map<String, int[]> map = new LinkedHashMap<>();
        for (String friend : friends) {
            map.put(friend, new int[friends.length]);
        }
        // 누가 누구에게 주었는지 저장
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            int[] arr = map.get(giver); // giver가 준 선물 리스트
            for (int j = 0; j < friends.length; j++) {
                if (receiver.equals(friends[j])) {
                    arr[j]++; // receiver에 해당하는 인덱스에 +1
                    break;
                }
            }
        }
        return map;
    }

    // 각 친구가 보낸 선물의 총 수
    public int[] sentGifts(Map<String, int[]> giftMap, String[] friends) {
        int[] send = new int[friends.length];
        int cnt = 0;
        for (String friend : giftMap.keySet()) {
            int[] sendGifts = giftMap.get(friend);
            int sendSum = 0;
            for (int i = 0; i < sendGifts.length; i++) {
                sendSum += sendGifts[i];
            }
            send[cnt] = sendSum;
            cnt++;
        }
        return send;
    }

    // 각 친구가 받은 선물의 총 수
    public int[] receivedGifts(Map<String, int[]> giftMap, String[] friends) {
        int[] receive = new int[friends.length];
        for (int[] gifts : giftMap.values()) {
            for (int i = 0; i < gifts.length; i++) {
                if (gifts[i] != 0) {
                    receive[i] += gifts[i];
                }
            }
        }
        return receive;
    }

    // 선물 지수
    public int[] giftScore(int[] send, int[] receive) {
        int[] result = new int[send.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = send[i] - receive[i];
        }
        return result;
    }

    // 주고받은 선물 총 수를 이차원 배열로
    public int[][] giftMatrix(Map<String, int[]> giftMap, String[] friends) {
        int[][] matrix = new int[friends.length][friends.length];
        int idx = 0;
        for (String friend : giftMap.keySet()) {
            matrix[idx] = giftMap.get(friend);
            idx++;
        }
        return matrix;
    }

    // 다음 선물을 계산
    public int[] nextGifts(int[][] giftMatrix, int[] result, String[] friends) {
        // 선물 받을 사람
        int[] nextGifts = new int[friends.length];
        // 전치행렬과 비교
        for (int i = 0; i < giftMatrix.length; i++) {
            for (int j = i; j < giftMatrix[i].length; j++) {
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    nextGifts[i]++;
                }
                if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    nextGifts[j]++;
                }
                if (i != j && (giftMatrix[i][j] == giftMatrix[j][i])) {
                    if (result[i] < result[j]) {
                        nextGifts[j]++;
                    } else if (result[i] > result[j]) {
                        nextGifts[i]++;
                    }
                }
            }
        }
        return nextGifts;
    }

    // 가장 많이 받을 사람
    public int findMax(int[] nextGifts) {
        int max = 0;
        for (int num : nextGifts) {
            max = Math.max(num, max);
        }
        return max;
    }
}