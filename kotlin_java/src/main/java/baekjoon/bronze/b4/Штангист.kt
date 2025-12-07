package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var ans = 0
    repeat(n) {
        val (x, y) = readln().split(Regex(" ")).map { it.toInt() }
        if (arr[it] == 1 && y > x) ans += (y - x)
    }
    println(ans)
}
