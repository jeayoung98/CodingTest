function solution(topping) {
    var answer = 0;
    const map = new Map();
    for(const i of topping){
        if(!map.has(i)) map.set(i,1);
        else{
            map.set(i,map.get(i) + 1);
        }
    }
    
    const set = new Set();
    for(const i of topping){
        if(map.get(i) === 1){
            map.delete(i);
        }else map.set(i,map.get(i) -1);
        set.add(i);
        if(set.size === map.size) answer++;
    }
    return answer;
}