package baekjoon.bronze.b2

fun main() {
    val (e, f, c) = readln().split(" ").map(String::toInt)
    var n = e + f
    var ans = 0
    while (n >= c) {
        val temp = n / c
        ans += temp
        n = n % c + temp
    }

    println(ans)
}