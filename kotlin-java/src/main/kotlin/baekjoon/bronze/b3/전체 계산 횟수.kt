package baekjoon.bronze.b3

fun main() {
    var (n, m) = readln().split(" ").map { it.toInt() }
    var ans = n
    while (n != 0) {
        n /= m
        ans += n
    }
    println(ans)
}
