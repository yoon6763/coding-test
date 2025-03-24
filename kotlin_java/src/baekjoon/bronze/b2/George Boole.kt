package baekjoon.bronze.b2

fun main() {
    val (a, oper, b) = readln().split(" ")
    val result = when (oper) {
        "AND" -> a == "true" && b == "true"
        "OR" -> a == "true" || b == "true"
        else -> a != b
    }
    println(result)
}