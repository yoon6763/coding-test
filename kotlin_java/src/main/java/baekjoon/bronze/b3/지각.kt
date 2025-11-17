package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val d = readln().toInt()
    var ans = 0
    while (d - ans - ans * ans >= 0) {
        ans++
    }

    println(ans - 1)
}