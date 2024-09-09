class Solution {
        static int[]  answer;  // 결과를 저장할 배열
    static int y = 1;  // 채워 넣을 숫자, 1부터 시작
    static int x;  // 남은 숫자의 수

    public static int[] solution(int n) {
        answer = new int[n*(n+1)/2];
        x = n;

        // 올라가는 숫자 , 2씩 더해주기
        int p = 0;
        // 현재 숫자 , 업데이트 해주기
        int q = 0;
        // 내려가는 숫자
        int c = n;
        while(true){
            q = down(p,q);
            x--;
            p += 2;
            if(x < 1) break;
            q = right(q);
            x--;
            if(x < 1) break;
            q = up(q, c);
            x--;
            c--;
            if(x < 1) break;
        }
        return answer;
    }

    // 아래로
    public static int down(int p, int q){
        for(int i = 0 ; i < x; i++){
            answer[p + q] = y;
            y++;
            q=p+q;
            p++;

        }

        return q;
    }

    // 오른쪽
    public static int right(int d){
        for(int i = 0; i < x; i++){
            answer[d + 1] = y;
            y++;
            d++;
        }
        return d;
    }

    // 위로
    public static int up(int r, int c){
        for(int i = 0; i < x; i++){
            answer[r - c] = y;
            y++;
            r = r-c;
            c--;
        }
        return r;
    }
}