function solution(n,a,b){
    var answer = 0;
    
    while(n >= 2){
        if((a > n / 2 && b > n / 2)||(a <= n / 2 && b <= n / 2)){
            n /= 2;
            if(a > n){
                a -= n;
                b -= n;
            }
        }
        else{
            answer = powNum(n);
            break;
        } 
    }
    if(n === 1) answer = 1;
    

    return answer;
}

function powNum(n){
    let result = 0;
    while(n > 1){
        n = n / 2;
        result++;
    }
    return result;
}