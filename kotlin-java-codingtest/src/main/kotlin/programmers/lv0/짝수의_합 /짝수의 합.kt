package programmers.lv0.`짝수의_합 `

fun solution(n: Int): Int {
    var sum = 0
    for(i in 2 .. n step 2) {
        sum += i
    }
    return sum
}