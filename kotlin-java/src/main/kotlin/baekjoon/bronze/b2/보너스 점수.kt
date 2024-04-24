package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val str = readln()
    var ans = 0
    var continous = 0

    repeat(n) {
        if (str[it] == 'O') {
            ans += continous
            continous++
            ans += it + 1
        } else {
            continous = 0
        }
    }
    println(ans)
}