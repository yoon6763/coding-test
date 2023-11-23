package baekjoon.bronze.b1

fun main() {
    val cow = Array(11) { -1 }
    var ans = 0
    repeat(readln().toInt()) {
        val (cowIdx, loc) = readln().split(" ").map { it.toInt() }
        if (cow[cowIdx] != -1 && cow[cowIdx] != loc) ans++
        cow[cowIdx] = loc
    }
    println(ans)
}