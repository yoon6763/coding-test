package baekjoon.bronze.b1

fun main() {
    val a = readln()
    val b = readln()

    println(
        when {
            a == "null" -> "NullPointerException"
            b == "null" -> "false"
            a == b -> "true"
            else -> "false"
        }
    )

    println(
        when {
            a == "null" -> "NullPointerException"
            b == "null" -> "false"
            a.equals(b, ignoreCase = true) -> "true"
            else -> "false"
        }
    )
}