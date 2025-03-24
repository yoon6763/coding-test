package baekjoon.bronze.b2

fun main() {
    val map = HashMap<Char, Int>()
    readln().uppercase().forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    ('A'..'Z').forEach { println("$it | ${"*".repeat(map.getOrDefault(it, 0))}") }
}