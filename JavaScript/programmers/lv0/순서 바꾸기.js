function solution(num_list, n) {
    var answer = [];
    for(var i = n; i < num_list.length; i++) {
        answer.push(num_list[i])
    }
    for(var i = 0; i < n; i++) {
        answer.push(num_list[i])
    }
    return answer;
}