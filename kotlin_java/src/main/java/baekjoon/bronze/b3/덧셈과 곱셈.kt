package baekjoon.bronze.b3


fun main() {
    val MOD = 14579
    val (a, b) = readln().split(" ").map { it.toInt() }
    var tmp = (1..a).sum()
    var answer = tmp
    for (i in a + 1..b) {
        answer *= (i.let { tmp += it; tmp })
        answer %= MOD
    }
    println(answer)
}
