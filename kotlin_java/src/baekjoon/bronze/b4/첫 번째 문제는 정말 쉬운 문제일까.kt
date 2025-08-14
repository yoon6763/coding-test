package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val a = List(n) { readln().toInt() }
    val first = a[0]
    val mn = a.min()
    val mx = a.max()

    when {
        first == mn -> println("ez")
        first == mx -> println("hard")
        else -> println("?")
    }
}