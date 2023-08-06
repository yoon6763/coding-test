package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val tower = readln().split(" ").map { it.toInt() }
    var ans = 1
    for (i in 1 until n) {
        if (tower[i-1] <= tower[i]) ans++
    }
    println(ans)
}