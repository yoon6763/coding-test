package baekjoon.bronze.b5

fun main() {
    val n1 = readln().toInt()
    val n2 = readln().toInt()

    if (n1 > n2) print(1)
    else if (n1 < n2) print(-1)
    else print(0)
}