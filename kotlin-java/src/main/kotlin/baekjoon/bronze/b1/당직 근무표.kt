package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    println(if (readln().split(" ").map { it.toInt() }.groupBy { it }
            .maxOf { it.value.size } > (n + 1) / 2) "NO" else "YES")
}
