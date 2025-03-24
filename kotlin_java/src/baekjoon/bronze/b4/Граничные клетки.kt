package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    if(n == 1 || m == 1) {
        println(n * m)
        return
    }
    println(n * m - (n - 2) * (m - 2))
}