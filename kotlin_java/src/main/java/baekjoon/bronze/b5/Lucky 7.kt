package baekjoon.bronze.b5

fun main() {
    val n = readln().toInt()
    println(if (n.toString().contains("7")) if (n % 7 != 0) 2 else 3 else if (n % 7 != 0) 0 else 1)
}