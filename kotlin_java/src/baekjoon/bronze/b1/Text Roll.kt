package baekjoon.bronze.b1

fun main() {
    while (true) {
        val n = readln().toInt().apply { if (this == 0) return }
        val lines = List(n) { readln().split(" ") }
        var cursor = 1

        for (i in 0 until n) {
            for (j in lines[i].indices) {
                val lengthSum = lines[i].subList(0, j + 1).sumOf { it.length }
                if (cursor <= lengthSum + j + 1) {
                    cursor = lengthSum + j + 1
                    break
                }
            }
        }

        println(cursor)
    }
}
