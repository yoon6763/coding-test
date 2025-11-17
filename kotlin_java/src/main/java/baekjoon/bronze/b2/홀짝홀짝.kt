package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val even = readln().count { it.digitToInt() % 2 == 0 }
    val odd = n - even

    println(
        when {
            even > odd -> 0
            even < odd -> 1
            else -> -1
        }
    )
}
