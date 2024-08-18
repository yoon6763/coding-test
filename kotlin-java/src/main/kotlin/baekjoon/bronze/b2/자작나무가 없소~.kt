package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, target) = readLine().split(" ")

    var cnt = 0
    repeat(n.toInt()) {
        val (name, score) = readLine().split(" ")
        if (target in name.split("_")) cnt += score.toInt()
    }
    print(cnt)
}