package baekjoon.bronze.b3

fun main() {
    val (n, p, s) = readln().split(" ").map { it.toInt() }

    repeat(s) {
        val set = mutableSetOf<Int>()
        val m = readln().split(" ").map { it.toInt() }

        for (j in 1..m[0]) set.add(m[j])

        println(if (p in set) "KEEP" else "REMOVE")
    }
}