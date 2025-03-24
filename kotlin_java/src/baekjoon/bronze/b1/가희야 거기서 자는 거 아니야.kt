package baekjoon.bronze.b1

fun main() {
    val (r, c) = readln().split(" ").map(String::toInt)
    val (rg, cg, rp, cp) = readln().split(" ").map(String::toInt)
    val map = Array(r) { readln().toCharArray() }
    var cnt = 0
    for (i in 0..<r) {
        for (j in 0..<c) {
            if (map[i][j] == 'P') cnt++
        }
    }
    println(if (cnt == rp * cp) 0 else 1)
}
