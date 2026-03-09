package baekjoon.bronze.b2

fun main() {
    val faces = listOf(
        setOf(0, 1, 2, 3),
        setOf(4, 5, 6, 7),
        setOf(0, 1, 4, 5),
        setOf(2, 3, 6, 7),
        setOf(0, 2, 4, 6),
        setOf(1, 3, 5, 7)
    )

    repeat(readln().toInt()) {
        val s = readln().split(" ").map { it.toInt() }.toSet()
        println(if (faces.any { it == s }) "YES" else "NO")
    }
}