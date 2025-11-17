package baekjoon.bronze.b3

fun main() {
    while (true) {
        val line = readln()
        if (line == "0") break

        repeat(line.toInt()) {
            val arr = readln().split(" ").map { it.toInt() }
            val marked = arr.mapIndexedNotNull { index, value ->
                if (value <= 127) index else null
            }

            println(if (marked.size == 1) ('A' + marked[0]) else '*')
        }
    }
}
