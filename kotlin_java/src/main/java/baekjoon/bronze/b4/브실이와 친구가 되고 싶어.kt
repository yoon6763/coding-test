package baekjoon.bronze.b4


fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (k, x) = readln().split(" ").map { it.toInt() }

    var ans = 0
    for (i in k - x..<k + x + 1) if (i in a..b) ans++
    if (ans == 0) print("IMPOSSIBLE") else print(ans)
}
