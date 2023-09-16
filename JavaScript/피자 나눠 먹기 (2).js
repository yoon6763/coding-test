function solution(n) {
    let answer = 1; 
    while ( (answer * 6) % n !== 0 ) {
        answer ++;
    }
    
    return answer;
}