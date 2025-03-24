package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val map = HashMap<String, Int>()
    repeat(readLine().toInt()) {
        val ext = readLine().split(".").last()
        map[ext] = map.getOrDefault(ext, 0) + 1
    }
    println(map.toList().sortedBy { it.first }.joinToString("\n") { "${it.first} ${it.second}" })
}