function solution(people, limit) {
    var answer = 0;
    people.sort((a,b) => a - b);
    let max = people.length - 1;
    for(let i = 0; i <= max; i++){
        if(people[i] + people[max] > limit) i--;
        max--;
        answer++;
    }
    return answer;
}