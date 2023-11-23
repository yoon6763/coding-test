package baekjoon.silver.s4

fun main():Unit = with(System.`in`.bufferedReader()) {
    readLine()
    val a = readLine().split(" ").map { it.toInt() }.toHashSet()
    val b = readLine().split(" ").map { it.toInt() }.toHashSet()

    // union - 합집합, subtract - 차집합
    println(a.subtract(b).union(b.subtract(a)).size)
}