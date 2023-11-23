package programmers.lv1.콜라_문제

fun solution(a: Int, b: Int, n: Int): Int {
    var answer = 0
    var cola = n
    while (cola >= a) {
        answer += cola / a * b
        cola = cola / a * b + cola % a
    }
    return answer
}