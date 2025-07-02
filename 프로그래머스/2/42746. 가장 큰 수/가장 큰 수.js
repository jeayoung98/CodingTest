function solution(numbers) {
    var answer = '';
    const arr = [];
    for(const i of numbers){
        arr.push(String(i));
    }
    arr.sort((a,b) => (b + a) - (a + b));
    
    if(arr[0] === "0") return "0";
    for(const i of arr){
        answer += i;
    }
    return answer;
}