package baekjoon.bronze.b3

fun main() {
    repeat(readln().trim().toInt()) {
        val input = readln().trim().split(" ").map { it.toInt() }

        val k = input[0]
        val rowCount = IntArray(9)

        var idx = 1
        repeat(k) {
            val col = input[idx++]
            val row = input[idx++]
            rowCount[row]++
        }

        println(rowCount.max())
    }
}