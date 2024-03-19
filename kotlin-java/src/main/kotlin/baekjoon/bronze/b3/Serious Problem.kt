package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val e = readln().count { it == 'e' }
    println(if (e > n - e) "e" else if (e < n - e) "2" else "yee")
}