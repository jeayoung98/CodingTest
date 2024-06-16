import java.util.*;

class Solution {
    int hpMax;
    int time;
    int currentHp;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        hpMax = health;
        currentHp = health;
        int lastTime = 0;
        for(int i = 0 ; i < attacks.length;i++){
            int attackTime = attacks[i][0];
            int attack = attacks[i][1];
            time = attackTime - lastTime;
            healing(bandage[0],bandage[1],bandage[2]);
            damage(attack);
            if(isDead()) return -1;
            lastTime = attackTime;
        }
        return currentHp;
    }
    
    // hp 증가 메서드
    public void hp(int heal){
        currentHp += heal;
        if(currentHp > hpMax){
            currentHp = hpMax;
        }
    }
    
    // 초당, 추가 회복량처리
    public void healing(int healTime,int hpPlus,int hpBonus){
        if(time == 1) return;
        hp((time - 1) * hpPlus);
        while(time > healTime){
            time -= healTime;
            hp(hpBonus);
        }
    }
    
    // 공격 받았을때
    public void damage(int attack){
        currentHp -= attack;
    }
    
    // 체력이 0이하인지 확인
    public boolean isDead(){
        boolean gg = false;
        if(currentHp <= 0){
            gg = true;
        }
        return gg;
    }
}
