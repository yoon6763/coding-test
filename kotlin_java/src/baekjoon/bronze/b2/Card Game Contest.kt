package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var ans = 1
    repeat(n) {
        var a = readln().toInt()
        if (a == 0) a = 1
        ans = (ans * a) % m
    }
    println(ans % m)
}