package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val map = HashMap<Int, Int>()
    repeat(readln().toInt()) {
        val num = readln().toInt()
        map[num] = map.getOrDefault(num, 0) + 1
    }
    val max = map.maxBy { it.value }
    println(map.filter { it.value == max.value }.toList().sortedBy { it.first }[0].first)
}