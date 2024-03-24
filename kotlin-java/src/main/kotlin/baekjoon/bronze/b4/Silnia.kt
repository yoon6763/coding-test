package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    if (n == 0) {
        println(1)
        return
    }

    if(n >= 10) {
        println(0)
        return
    }

    var result = 1
    for (i in 1..n) {
        result *= i
        result %= 10
    }
    println(result)
}