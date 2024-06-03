import java.util.*;

class Solution {
    static int hpMax;
    static int time;
    static int currentHp;
    
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
    
    public void hp(int heal){
        currentHp += heal;
        if(currentHp > hpMax){
            currentHp = hpMax;
        }
    }
    
    public void healing(int healTime,int hpPlus,int hpBonus){
        if(time == 1) return;
        hp((time - 1) * hpPlus);
        while(time > healTime){
            time -= healTime;
            hp(hpBonus);
        }
    }
    
    public void damage(int attack){
        currentHp -= attack;
    }
    
    public boolean isDead(){
        boolean gg = false;
        if(currentHp <= 0){
            gg = true;
        }
        return gg;
    }
}
