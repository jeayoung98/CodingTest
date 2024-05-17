import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0; 
       
        Map<String, int[]>map = new LinkedHashMap<>();
        for(int i=0;i<friends.length;i++){
            map.put(friends[i] , new int[friends.length]);
        }
        
        for(int i=0;i<gifts.length;i++){
            String[] str = gifts[i].split(" ");//muzi , frodo
            int[] arr = map.get(str[0]); // muzi 가 준사람 list
            for(int j=0;j<arr.length;j++){ // list 반복문
                if(str[1].equals(friends[j])){// friends와 str[1] frodo 값이 같을때 인덱스 찾기
                    arr[j]+=1;
                    map.put(str[0] , arr);// muzi가 준사람중에 forodo index에 +1
                    break;
                }
            }
        }
        int[] send = new int[friends.length];
        int[] recieve = new int[friends.length];
        int cnt1=0;
        for(String str : map.keySet()){
            //str의 준 선물 구하기
            int[] sendGift = map.get(str);
            int sendSum =0;
            for(int i=0;i<sendGift.length;i++){
                sendSum+=sendGift[i];
                if(sendGift[i]!=0){
                    recieve[i]+=sendGift[i];
                }
            }
            send[cnt1] = sendSum;
            cnt1++;
            //str의 받은 선물 구하기
            
        }
        int[] result = new int[friends.length];
        for(int i=0;i<result.length;i++){
            result[i] = send[i]-recieve[i];
        }
        int max=result[0];
        for(int a : result){
            if(max<a){
                max = a;
            }
        }
        
        int[][] arr2 = new int[friends.length][friends.length];
        int idx=0;
        for(String str : map.keySet()){
            
            arr2[idx]= map.get(str);
            idx++;
        }
        
        int[] recieveMore = new int[friends.length];
        for(int i=0;i<arr2.length;i++){
            for(int j=i;j<arr2[i].length;j++){
                if(arr2[i][j]>arr2[j][i]) recieveMore[i]++;
                if(arr2[i][j]<arr2[j][i]) recieveMore[j]++;
                if(i!=j && (arr2[i][j] == arr2[j][i])){
                    if(result[i]<result[j]){
                        recieveMore[j]+=1;
                    }else if(result[i]==result[j]){
                        
                    }
                    else{
                        recieveMore[i]+=1;
                    }
                }
            }
          
        }
        int max1=0;
        for(int num : recieveMore){
            max1=Math.max(num,max1);
        }
        answer=max1;
        // for(int i=0;i<send.length;i++){
        //     System.out.println(result[i]);
        // }
        return answer;
    }
}