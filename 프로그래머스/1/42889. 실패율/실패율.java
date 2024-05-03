import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2];
        
        // 각 스테이지 클리어 못한 사람
        for (int stage : stages) {
            stageCount[stage]++;
        }

        // 각 스테이지에 도달한 사람
        int[] reachCount = new int[N + 2];
        reachCount[1] = stages.length;
        for (int i = 2; i <= N; i++) {
            reachCount[i] = reachCount[i - 1] - stageCount[i - 1];
        }

        // 스테이지 별 실패율
        List<FailRate> failRates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            double failRate = reachCount[i] == 0 ? 0 : (double) stageCount[i] / reachCount[i];
            failRates.add(new FailRate(i, failRate));
        }

        // 실패율 기준 내림차순, 실패율이 같다면 스테이지 번호 작은 순
        Collections.sort(failRates, new Comparator<FailRate>() {
            @Override
            public int compare(FailRate fail1, FailRate fail2) {
                if (fail1.failRate == fail2.failRate) {
                    return fail1.stage - fail2.stage;
                }
                return Double.compare(fail2.failRate, fail1.failRate);
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = failRates.get(i).stage;
        }
        return answer;
    }
}

class FailRate {
    int stage;
    double failRate;

    public FailRate(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }
}