package programmers.lv0.자릿수_더하기

fun solution(n: Int): Int {
    var tempN = n;
    var sum = 0
    while(tempN > 0) {
        sum += tempN % 10
        tempN /= 10
    }
    return sum
}