package baekjoon.bronze.b3

fun main() {
    readln()
    val map = mutableMapOf<Char, Int>()
    readln().forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    val list = map.filter { it.value == map.maxOf { it.value } }.map { it.key }.toList()
    if (list.size == 3) println("SCU")
    else {
        val sb = StringBuilder()
        if ('B' in list) sb.append('B')
        if ('S' in list) sb.append('S')
        if ('A' in list) sb.append('A')
        println(sb.toString())
    }
}