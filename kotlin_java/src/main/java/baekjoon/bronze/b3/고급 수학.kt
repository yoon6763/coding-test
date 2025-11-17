package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val arr = readLine().split(" ").map { it.toInt() }.sorted()
        if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
            println("Scenario #${it + 1}: \nyes")
        } else {
            println("Scenario #${it + 1}: \nno")
        }
        if (it != t - 1) println()
    }
}