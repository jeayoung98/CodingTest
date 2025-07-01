function solution(elements) {
    var answer = 0;
    const set = new Set();
    for(let i = 0; i < elements.length; i++){
        for(let j = 0; j < elements.length; j++){
            let currentSum = 0;
            for(let k = 0; k < i; k++){
                currentSum += elements[(j + k) % elements.length];
            }
            set.add(currentSum);
        }
    }
    
    return set.size;
}