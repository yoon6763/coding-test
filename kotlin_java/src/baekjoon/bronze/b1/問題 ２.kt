package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val map = mutableMapOf<String, String>()
    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ")
        map[a] = b
    }
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val a = readLine()
        sb.append(map.getOrDefault(a, a))
    }
    print(sb)
}