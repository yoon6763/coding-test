package baekjoon.bronze.b3

fun main() {
    generateSequence { readln().split(" ").map { it.toDouble() } }
        .takeWhile { it.any { num -> num != 0.0 } }
        .forEach { arr ->
            val avg = arr.sorted().drop(1).dropLast(1).average()
            println(if (avg % 1.0 == 0.0) avg.toInt() else avg)
        }
}