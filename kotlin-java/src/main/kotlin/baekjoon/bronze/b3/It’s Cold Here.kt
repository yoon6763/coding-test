package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val map = mutableMapOf<String, Int>()
    while (true) {
        val line = readLine() ?: break
        val (city, temp) = line.split(" ")
        map[city] = temp.toInt()
    }

    println(map.minByOrNull { it.value }!!.key)
}