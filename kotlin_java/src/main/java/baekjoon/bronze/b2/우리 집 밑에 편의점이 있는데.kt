package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }
    var map = mutableMapOf<Int, Int>()
    arr.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    println(map[map.maxByOrNull { it.value }!!.key])
}