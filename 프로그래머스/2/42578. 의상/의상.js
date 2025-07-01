function solution(clothes) {
    var answer = 1;
    const map = new Map();
    for(const i of clothes){
        if(map.has(i[1])){
            map.set(i[1], map.get(i[1]) + 1);
        }else {
            map.set(i[1],1);
        }
    }
    
    for (const count of map.values()) {
            answer *= (count + 1);
        }
        return answer - 1;
    
    console.log(map);
    return answer;
}