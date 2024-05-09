package baekjoon.bronze.b3

fun main() {
    readln()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    readln()
    val b = readln().split(" ").map { it.toInt() }.toSet()

    var ans = 0

    a.forEach {
        ans += it
        if (b.contains(ans)) ans = 0
    }

    println(ans)
}