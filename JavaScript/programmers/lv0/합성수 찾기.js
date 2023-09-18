function solution(n) {
    var answer = 0;
    
    for(var i = 1; i <= n; i++) {
        var cnt = 0
        for(var j = 1; j <= n; j++) {
            if(i % j === 0) {
                cnt += 1
            }
        }

        if(cnt >= 3) {
            answer += 1
        }
    }
    return answer;
}