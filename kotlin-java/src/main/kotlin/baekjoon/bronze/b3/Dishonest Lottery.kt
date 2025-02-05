package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    List(n * 10) { readLine().split(" ") }.flatten().groupingBy { it.toInt() }.eachCount().filter { it.value > 2 * n }.keys.sorted().let {
        println(if (it.isEmpty()) -1 else it.joinToString("\n"))
    }
}