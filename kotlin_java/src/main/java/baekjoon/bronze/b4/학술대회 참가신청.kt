package baekjoon.bronze.b4

fun main() {
    val keyword = readln().lowercase()

    val d = listOf("social", "history", "language", "literacy")
    val p = listOf("bigdata", "public", "society")

    if (d.any { it in keyword }) {
        println("digital humanities")
    } else if (p.any { it in keyword }) {
        println("public bigdata")
    }
}
