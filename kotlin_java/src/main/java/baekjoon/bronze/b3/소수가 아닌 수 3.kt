package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val d = readln().split(" ")

    println("YES")
    println(if (n == 1 && d[0] == "0") 0 else d[n - 1].repeat(3))
}
