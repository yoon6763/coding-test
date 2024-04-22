package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine()
        val n1 = n.sumOf { it.digitToInt() }
        val n2 = n.substring(10, 13).toInt() * 10

        var sum = n1 + n2
        if (sum < 1000) sum += 1000
        else sum %= 10000

        println("%04d".format(sum))
    }
}