package baekjoon.silver.s5

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    if(n == 0) {
        println(0)
        return
    }
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()

    var ans = if (n > 0) 1 else 0
    var acc = 0

    arr.forEach {
        acc += it
        if (acc <= m) return@forEach
        ans++
        acc = it
    }
    println(ans)
}
