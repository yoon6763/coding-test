package baekjoon.bronze.b2

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        val list = List(n) { readln().toInt() }.sorted().toMutableList()
        list.removeLast()
        list.removeFirst()
        println(list.sum() / list.size)
    }
}