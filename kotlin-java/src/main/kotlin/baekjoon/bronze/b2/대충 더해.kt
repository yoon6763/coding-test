package baekjoon.bronze.b2

fun main() {
    val (a, b) = readln().split(" ").map { it.reversed() }
    val list = mutableListOf<Int>()
    val max = maxOf(a.length, b.length)
    for (i in 0..<max) {
        val num = a.getOrNull(i)?.digitToInt()?.plus(b.getOrNull(i)?.digitToInt() ?: 0) ?: b.getOrNull(i)?.digitToInt() ?: 0
        list.add(num)
    }
    println(list.reversed().joinToString(""))
}